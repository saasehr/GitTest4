package com.hospini.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hospini.api.coderep.service.JwtUserService;
import com.hospini.api.exception.ColumnValueNullException;
import com.hospini.api.exception.CustomException;
import com.hospini.api.exception.ResourceAlreadyExistsException;
import com.hospini.api.trxrep.model.OrgUser;
import com.hospini.api.trxrep.model.Organization;
import com.hospini.api.trxrep.service.AccountActivationService;
import com.hospini.api.trxrep.service.OrgUserRegService;
import com.hospini.api.trxrep.service.OrgUserService;
import com.hospini.api.trxrep.service.OrganizationService;

//import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/api")
public class AuthController {
    @Autowired
    JwtUserService jwtUserServiceHandle;
    @Autowired
    OrganizationService orgServiceHandle;
    @Autowired
    OrgUserService orgUserServiceHandle;
    @Autowired
    OrgUserRegService orgUserRegSrvcHandle;
    @Autowired
    AccountActivationService accountActivationSrvcHandle;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping(value = "/signup")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody Map<String, Object> orgMap) {

        Map<String, Object> respMap = new HashMap<>();

        Map<String, Object> userMap = Map.of();

        // Check for org id null

        logger.info("Validating Org and Org User information");

        if ((String) orgMap.get("org_email_id") == null || (String) orgMap.get("org_email_id") == "") {
            throw new ColumnValueNullException("Organization Email ID can not be null or blank");
        }

        if ((String) orgMap.get("org_name") == null || (String) orgMap.get("org_name") == "") {
            throw new ColumnValueNullException("Organization name can not be null or blank");
        }

        if ((String) orgMap.get("org_user_full_name") == null || (String) orgMap.get("org_user_full_name") == "") {
            throw new ColumnValueNullException("Organization user name can not be null or blank");
        }

        if ((String) orgMap.get("login_email_id") == null || (String) orgMap.get("login_email_id") == "") {
            throw new ColumnValueNullException("Organization user email can not be null or blank");
        }

        if ((String) orgMap.get("create_dtm") == null || (String) orgMap.get("create_dtm") == "") {
            throw new ColumnValueNullException("Create date time can not be null or blank");
        }

        if ((String) orgMap.get("org_mobile_no") == null || (String) orgMap.get("org_mobile_no") == "") {
            throw new ColumnValueNullException("Organization mobile number can not be null or blank");
        }

        if ((String) orgMap.get("org_landline") == null || (String) orgMap.get("org_landline") == "") {
            throw new ColumnValueNullException("Organization landline number can not be null or blank");
        }

        if ((String) orgMap.get("org_user_password") == null || (String) orgMap.get("org_user_password") == "") {
            throw new ColumnValueNullException("Organization mobile number can not be null or blank");
        }

        if ((Integer) orgMap.get("c_country_id") == null) {
            throw new ColumnValueNullException("Country code can not be null");
        }

        if ((String) orgMap.get("org_zip_code") == null || (String) orgMap.get("org_zip_code") == "") {
            throw new ColumnValueNullException("Zip code can not be null or blank");
        }

        List<Organization> orgList = orgServiceHandle.getOrgByEmailId((String) orgMap.get("org_email_id"));
        List<OrgUser> orgUserList = orgUserServiceHandle.getOrgUserIdByEmailId((String) orgMap.get("login_email_id"));

        // check if org and user already exist but not activated

       /* if (!orgList.isEmpty() && !orgUserList.isEmpty()) {

            if ((orgList.get(0).getOrg_email_id().equals((String) orgMap.get("org_email_id"))
                    && orgList.get(0).getActive_flag() == 0)
                    && (orgUserList.get(0).getLogin_email_id().equals((String) orgMap.get("login_email_id"))
                            && orgUserList.get(0).getActive_flag() == 0)) {

                respMap.put("message", "Account is inactive, use login page to activate the account");
                return new ResponseEntity<>(respMap, HttpStatus.OK);

            }

        }
		*/

        if (!orgList.isEmpty()) {

            if (orgList.get(0).getOrg_email_id().equals((String) orgMap.get("org_email_id"))
                    && orgList.get(0).getActive_flag() == 1) {

                throw new ResourceAlreadyExistsException(
                        "Organization with the given email already exists: " + (String) orgMap.get("org_email_id"));
            }
        }

        if (!orgUserList.isEmpty()) {
            if (orgUserList.get(0).getLogin_email_id().equals((String) orgMap.get("login_email_id"))
                    && orgUserList.get(0).getActive_flag() == 1) {
                throw new ResourceAlreadyExistsException("An active user already exists for the given organization: "
                        + (String) orgMap.get("login_email_id"));

            }
        }

        // check if an active user exists

        logger.info("Calling signup user");

        try {
            userMap = orgUserRegSrvcHandle.signUpUser(orgMap);
        } catch (Exception e) {
            // e.printStackTrace();
            throw new CustomException("Error while signing up the user", e);
        }

        // send email to user for account activation

        // logger.info("Email Confirmation email sent");

        respMap.put("Org_User_Details", userMap);
        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/confirmEmail")
    @ResponseBody
    public ResponseEntity<?> confirmEmail(@RequestParam("token") String token) {

        System.out.println("Confirm email link clicked =" + token);

        try {
            if (accountActivationSrvcHandle.activateAccount(token))

                return new ResponseEntity<>("Your user account has been activated, please login using the login page",
                        HttpStatus.OK);

            else {

                System.out.println("Account is empty in controller");

                return new ResponseEntity<>("Could not activate the account, email confirmation timeout",
                        HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            throw new CustomException("Error activating the user", ex);
        }
    }

    @GetMapping(value = "/activateAccount")
    @ResponseBody
    public ResponseEntity<?> activate(@RequestParam("token") String token) {

        System.out.println("Confirm email link clicked =" + token);
        return new ResponseEntity<>("Account Activated", HttpStatus.OK);
    }

}
