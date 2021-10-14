package com.hospini.api.controller;

import java.util.HashMap;
import java.util.Map;

import com.hospini.api.coderep.service.AllergyCodeCategoryService;
import com.hospini.api.coderep.service.AppointmentSlotDurationService;
import com.hospini.api.coderep.service.AppointmentStatusCodeService;
import com.hospini.api.coderep.service.AppointmentTimeSlotService;
import com.hospini.api.coderep.service.CancelReasonCodeService;
import com.hospini.api.coderep.service.CodeAppointmentTypeService;
import com.hospini.api.coderep.service.CodeNoteTypeService;
import com.hospini.api.coderep.service.ConditionCodeTypeService;
import com.hospini.api.coderep.service.CountryCodeService;
import com.hospini.api.coderep.service.CurrencyCodeService;
import com.hospini.api.coderep.service.EncounterTypeCodeService;
import com.hospini.api.coderep.service.FamilyRelationCodeService;
import com.hospini.api.coderep.service.GenderCodeService;
import com.hospini.api.coderep.service.Icd10CmCodeService;
import com.hospini.api.coderep.service.Icd10PcsCodeService;
import com.hospini.api.coderep.service.LabActivityTypeCodeService;
import com.hospini.api.coderep.service.OrderTypeCodeService;
import com.hospini.api.coderep.service.PackageCatalogCodeService;
import com.hospini.api.coderep.service.PaymentGateWayService;
import com.hospini.api.coderep.service.PaymentTypeService;
import com.hospini.api.coderep.service.PharmacyFoodService;
import com.hospini.api.coderep.service.PharmacyFreqCodeService;
import com.hospini.api.coderep.service.PharmacyRouteCodeService;
import com.hospini.api.coderep.service.ProductFeatureCodeService;
import com.hospini.api.coderep.service.RenewalPeriodCodeService;
import com.hospini.api.coderep.service.RoleCodeService;
import com.hospini.api.coderep.service.SocialHistoryCategoryService;
import com.hospini.api.coderep.service.SubscriptionPlanCodeService;
import com.hospini.api.coderep.service.TimeZoneCodeService;
import com.hospini.api.coderep.service.VaccineCodeService;
import com.hospini.api.coderep.service.VitalSignsCodeService;
import com.hospini.api.coderep.service.WeekStartDayCodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/api")
public class ConfigDataController {

    @Autowired
    AllergyCodeCategoryService allergyCodeCategoryServiceHandle;
    @Autowired
    AppointmentSlotDurationService appSlotDurationHandle;
    @Autowired
    AppointmentTimeSlotService apptTimeSlotSrvcHandle;
    @Autowired
    CodeAppointmentTypeService codeApptTypeSrvcHandle;
    @Autowired
    CancelReasonCodeService cancelReasonCdSrvcHandle;
    @Autowired
    AppointmentStatusCodeService apptStatusCodeSrvcHandle;
    @Autowired
    CountryCodeService countryCodeserviceHandle;
    @Autowired
    CurrencyCodeService currencyCodeServiceHandle;
    @Autowired
    EncounterTypeCodeService encntrTypeCodeSrvcHandle;
    @Autowired
    FamilyRelationCodeService famlilyRelCodeSrvcHandle;
    @Autowired
    GenderCodeService genderCodeSrvcHandle;
    @Autowired
    Icd10CmCodeService icd10CmCodeSrvcHandle;
    @Autowired
    Icd10PcsCodeService icd10PcsCodeServiceHandle;
    @Autowired
    LabActivityTypeCodeService labActTypeCodeSrvcHandle;
    @Autowired
    ConditionCodeTypeService condCodeSrvcHandle;
    @Autowired
    CodeNoteTypeService codeNoteTypeServiceHandle;
    @Autowired
    OrderTypeCodeService orderTypeCodeServiceHandle;
    @Autowired
    PackageCatalogCodeService packCatalogCodeServiceHandle;
    @Autowired
    PaymentGateWayService paymentGateWayServiceHandle;
    @Autowired
    PaymentTypeService paymentTypeServiceHandle;
    @Autowired
    PharmacyFoodService pharamcyFoodServiceHandle;
    @Autowired
    PharmacyFreqCodeService pharmacyFreqCodeSrvcHandle;
    @Autowired
    PharmacyRouteCodeService pharmacyRouteCodeServiceHandle;
    @Autowired
    SubscriptionPlanCodeService subscriptionPlanSrvcHandle;
    @Autowired
    ProductFeatureCodeService prodFeatureCodeSrvcHandle;
    @Autowired
    RenewalPeriodCodeService renewalPeriodCodeServiceHandle;
    @Autowired
    RoleCodeService roleCodeServiceHandle;
    @Autowired
    SocialHistoryCategoryService shxCategoryServiceHandle;
    @Autowired
    TimeZoneCodeService timeZoneCodeServiceHandle;
    @Autowired
    VaccineCodeService vaccineCodeSrvcHandle;
    @Autowired
    VitalSignsCodeService vitalSignsCodeSrvcHandle;
    @Autowired
    WeekStartDayCodeService weekStartDayCodeSrvcHandle;

    @GetMapping(value = "/getAllergyCodeCategorys")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllergyCodeVCategory() {

        var allergyCodeCategories = allergyCodeCategoryServiceHandle.getAllergyCodeCategories();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("allergy_category", allergyCodeCategories);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getApptSlotDurations")
    @ResponseBody

    public ResponseEntity<Map<String, Object>> getApptSlotDuration() {

        var apptSlotDuration = appSlotDurationHandle.getAppointmentSlotDuration();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("appointment_slot_duration", apptSlotDuration);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getAppointmentTimeSlots")
    @ResponseBody

    public ResponseEntity<Map<String, Object>> getAppointmentTimeSlot() {

        var apptTimeSlot = apptTimeSlotSrvcHandle.getAppointmentTimeSlot();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("appointment_time_slot", apptTimeSlot);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getCodeAppointmentTypes")
    @ResponseBody

    public ResponseEntity<Map<String, Object>> getCodeAppointmentTypes() {

        var codeApptType = codeApptTypeSrvcHandle.getCodeAppointmentType();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_appointment_type", codeApptType);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getCancelReasonCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getCancelReasonCodes() {

        var cancelReasonCode = cancelReasonCdSrvcHandle.getCancelResonCode();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("cancel_reason_code", cancelReasonCode);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getAppointmentStatusCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAppoimentStatusCodes() {

        var apptStatusCode = apptStatusCodeSrvcHandle.getAppointmentStatusCode();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("appointment_status_code", apptStatusCode);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getCountryCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getCountryCodes() {

        var counntryCode = countryCodeserviceHandle.getCountryCode();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("country_code", counntryCode);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getCurrencyCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getcurrencyCodes() {

        var currencyCodes = currencyCodeServiceHandle.getCurrencyCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("currency_code", currencyCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getEncounterTypeCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getEncounterTypeCodes() {

        var encntrTypeCodes = encntrTypeCodeSrvcHandle.getEncntrTypeCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("currency_code", encntrTypeCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getFamilyRelCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getFamilyRelTypeCodes() {

        var familyRelCodes = famlilyRelCodeSrvcHandle.getFamilyRelationCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("family_relation_code", familyRelCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getGenderCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getGenderCodes() {

        var genderCodes = genderCodeSrvcHandle.getGenderCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("gender_codes", genderCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getIcd10CmCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getIcd10CmCodes() {

        var icd10CmCodes = icd10CmCodeSrvcHandle.getIcd10CmCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("icd10_code_cm", icd10CmCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getIcd10PcsCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getIcd10PcsCodes() {

        var icd10PcsCodes = icd10PcsCodeServiceHandle.getIcd10PcsCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("icd10_code_pcs", icd10PcsCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getLabActTypeCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getLabActTypeCodes() {

        var labActTypeCodes = labActTypeCodeSrvcHandle.getLabActivityTypeCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("lab_activity_type_code", labActTypeCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getConditionCodeTypes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getConditionCodeTypes() {

        var condCodetypes = condCodeSrvcHandle.getConditionCodeTypes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("condition_type_code", condCodetypes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getCodeNoteTypes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getCodeNoteTypes() {

        var codeNoteTypes = codeNoteTypeServiceHandle.getCodeNoteTypes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_note_type", codeNoteTypes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getOrderTypeCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getOrderTypeCodes() {

        var orderTypeCodes = orderTypeCodeServiceHandle.getOrderTypeCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("order_type_code", orderTypeCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getPaymentGateWays")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getPaymentGateWays() {

        var paymentGateWays = paymentGateWayServiceHandle.getPaymentGateWays();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_payment_gateway", paymentGateWays);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getPaymentTypes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getPaymentTypes() {

        var paymentTypes = paymentTypeServiceHandle.getPaymentTypes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_payment_type", paymentTypes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getPharmacyFoodCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getPharmacyFoodCodes() {

        var pharmacyFoodCodes = pharamcyFoodServiceHandle.getPharmacyFoodCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_pharmacy_food", pharmacyFoodCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getPharmacyFreqCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getPharmacyFreqCodes() {

        var pharmacyFreqCodes = pharmacyFreqCodeSrvcHandle.getPharmacyFreqCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_pharmacy_frequency", pharmacyFreqCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getPharmacyRouteCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getPharmacyRouteCodes() {

        var pharmacyRouteCodes = pharmacyRouteCodeServiceHandle.getPharmacyRouteCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_pharmacy_route", pharmacyRouteCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getSubscriptionPlanCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getSubscriptionPlanCodes() {

        var subplancodes = subscriptionPlanSrvcHandle.getSubscriptionPlanCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_subscription_plan", subplancodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getProductFeatureCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getProductFeatureCodes() {

        var prodFeatureCodes = prodFeatureCodeSrvcHandle.getProdFeatureCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_product_feature", prodFeatureCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getRenewalPeriodCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getRenewalPeriodCodes() {

        var renewalPeriodCodes = renewalPeriodCodeServiceHandle.getRenewalPeriodCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_renewal_period", renewalPeriodCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getRoleCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getRoleCodes() {

        var roleCodes = roleCodeServiceHandle.getRoleCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_role", roleCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getShxCategories")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getShxCategories() {

        var shxCategories = shxCategoryServiceHandle.getShxCategories();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("social_history_category", shxCategories);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getTimeZoneCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getTimeZoneCodes() {

        var timeZoneCodes = timeZoneCodeServiceHandle.getTimeZoneCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_time_zone", timeZoneCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getVaccineCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getVaccineCodes() {

        var vaccineCodes = vaccineCodeSrvcHandle.getVaccineCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_vaccine", vaccineCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getVitalSignsCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getVitalSignsCodes() {

        var vitalSignCodes = vitalSignsCodeSrvcHandle.getVitalSignsCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_vital_signs", vitalSignCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

    @GetMapping(value = "/getWeekStartDayCodes")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getWeekStartDayCodes() {

        var weekStartDayCodes = weekStartDayCodeSrvcHandle.getWeekStartDayCodes();

        Map<String, Object> respMap = new HashMap<>();
        respMap.put("code_week_start_day", weekStartDayCodes);

        return new ResponseEntity<>(respMap, HttpStatus.OK);

    }

}
