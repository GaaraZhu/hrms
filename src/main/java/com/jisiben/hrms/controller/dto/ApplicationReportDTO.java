package com.jisiben.hrms.controller.dto;

import com.jisiben.hrms.domain.entity.Branch;

import java.util.HashMap;
import java.util.Map;

public class ApplicationReportDTO {
    private String company;
    private String city;
    private String district;
    private String branch;
    private String creatorName;
    private String month;
    private int onboard1st10Ds;
    private int resign1st10Ds;
    private int onboardD1;
    private int resignD1;
    private int onboardD2;
    private int resignD2;
    private int onboardD3;
    private int resignD3;
    private int onboardD4;
    private int resignD4;
    private int onboardD5;
    private int resignD5;
    private int onboardD6;
    private int resignD6;
    private int onboardD7;
    private int resignD7;
    private int onboardD8;
    private int resignD8;
    private int onboardD9;
    private int resignD9;
    private int onboardD10;
    private int resignD10;
    private int onboard2nd10Ds;
    private int resign2nd10Ds;
    private int onboardD11;
    private int resignD11;
    private int onboardD12;
    private int resignD12;
    private int onboardD13;
    private int resignD13;
    private int onboardD14;
    private int resignD14;
    private int onboardD15;
    private int resignD15;
    private int onboardD16;
    private int resignD16;
    private int onboardD17;
    private int resignD17;
    private int onboardD18;
    private int resignD18;
    private int onboardD19;
    private int resignD19;
    private int onboardD20;
    private int resignD20;
    private int onboard3rd10Ds;
    private int resign3rd10Ds;
    private int onboardD21;
    private int resignD21;
    private int onboardD22;
    private int resignD22;
    private int onboardD23;
    private int resignD23;
    private int onboardD24;
    private int resignD24;
    private int onboardD25;
    private int resignD25;
    private int onboardD26;
    private int resignD26;
    private int onboardD27;
    private int resignD27;
    private int onboardD28;
    private int resignD28;
    private int onboardD29;
    private int resignD29;
    private int onboardD30;
    private int resignD30;
    private int onboardD31;
    private int resignD31;
    private int onboard;
    private int resign;

    ApplicationReportDTO() {}

    ApplicationReportDTO(Builder builder) {
        this.company=builder.company;
        this.city=builder.city;
        this.district=builder.district;
        this.branch=builder.branch;
        this.creatorName=builder.creatorName;
        this.month=builder.month;
        this.onboard1st10Ds=builder.onboard1st10Ds;
        this.resign1st10Ds=builder.resign1st10Ds;
        this.onboardD1=builder.onboardD1;
        this.resignD1=builder.resignD1;
        this.onboardD2=builder.onboardD2;
        this.resignD2=builder.resignD2;
        this.onboardD3=builder.onboardD3;
        this.resignD3=builder.resignD3;
        this.onboardD4=builder.onboardD4;
        this.resignD4=builder.resignD4;
        this.onboardD5=builder.onboardD5;
        this.resignD5=builder.resignD5;
        this.onboardD6=builder.onboardD6;
        this.resignD6=builder.resignD6;
        this.onboardD7=builder.onboardD7;
        this.resignD7=builder.resignD7;
        this.onboardD8=builder.onboardD8;
        this.resignD8=builder.resignD8;
        this.onboardD9=builder.onboardD9;
        this.resignD9=builder.resignD9;
        this.onboardD10=builder.onboardD10;
        this.resignD10=builder.resignD10;
        this.onboard2nd10Ds=builder.onboard2nd10Ds;
        this.resign2nd10Ds=builder.resign2nd10Ds;
        this.onboardD11=builder.onboardD11;
        this.resignD11=builder.resignD11;
        this.onboardD12=builder.onboardD12;
        this.resignD12=builder.resignD12;
        this.onboardD13=builder.onboardD13;
        this.resignD13=builder.resignD13;
        this.onboardD14=builder.onboardD14;
        this.resignD14=builder.resignD14;
        this.onboardD15=builder.onboardD15;
        this.resignD15=builder.resignD15;
        this.onboardD16=builder.onboardD16;
        this.resignD16=builder.resignD16;
        this.onboardD17=builder.onboardD17;
        this.resignD17=builder.resignD17;
        this.onboardD18=builder.onboardD18;
        this.resignD18=builder.resignD18;
        this.onboardD19=builder.onboardD19;
        this.resignD19=builder.resignD19;
        this.onboardD20=builder.onboardD20;
        this.resignD20=builder.resignD20;
        this.onboard3rd10Ds=builder.onboard3rd10Ds;
        this.resign3rd10Ds=builder.resign3rd10Ds;
        this.onboardD21=builder.onboardD21;
        this.resignD21=builder.resignD21;
        this.onboardD22=builder.onboardD22;
        this.resignD22=builder.resignD22;
        this.onboardD23=builder.onboardD23;
        this.resignD23=builder.resignD23;
        this.onboardD24=builder.onboardD24;
        this.resignD24=builder.resignD24;
        this.onboardD25=builder.onboardD25;
        this.resignD25=builder.resignD25;
        this.onboardD26=builder.onboardD26;
        this.resignD26=builder.resignD26;
        this.onboardD27=builder.onboardD27;
        this.resignD27=builder.resignD27;
        this.onboardD28=builder.onboardD28;
        this.resignD28=builder.resignD28;
        this.onboardD29=builder.onboardD29;
        this.resignD29=builder.resignD29;
        this.onboardD30=builder.onboardD30;
        this.resignD30=builder.resignD30;
        this.onboardD31=builder.onboardD31;
        this.resignD31=builder.resignD31;
        this.onboard=builder.onboard;
        this.resign=builder.resign;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getBranch() {
        return branch;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public String getMonth() {
        return month;
    }

    public int getOnboard1st10Ds() {
        return onboard1st10Ds;
    }

    public int getResign1st10Ds() {
        return resign1st10Ds;
    }

    public int getOnboardD1() {
        return onboardD1;
    }

    public int getResignD1() {
        return resignD1;
    }

    public int getOnboardD2() {
        return onboardD2;
    }

    public int getResignD2() {
        return resignD2;
    }

    public int getOnboardD3() {
        return onboardD3;
    }

    public int getResignD3() {
        return resignD3;
    }

    public int getOnboardD4() {
        return onboardD4;
    }

    public int getResignD4() {
        return resignD4;
    }

    public int getOnboardD5() {
        return onboardD5;
    }

    public int getResignD5() {
        return resignD5;
    }

    public int getOnboardD6() {
        return onboardD6;
    }

    public int getResignD6() {
        return resignD6;
    }

    public int getOnboardD7() {
        return onboardD7;
    }

    public int getResignD7() {
        return resignD7;
    }

    public int getOnboardD8() {
        return onboardD8;
    }

    public int getResignD8() {
        return resignD8;
    }

    public int getOnboardD9() {
        return onboardD9;
    }

    public int getResignD9() {
        return resignD9;
    }

    public int getOnboardD10() {
        return onboardD10;
    }

    public int getResignD10() {
        return resignD10;
    }

    public int getOnboard2nd10Ds() {
        return onboard2nd10Ds;
    }

    public int getResign2nd10Ds() {
        return resign2nd10Ds;
    }

    public int getOnboardD11() {
        return onboardD11;
    }

    public int getResignD11() {
        return resignD11;
    }

    public int getOnboardD12() {
        return onboardD12;
    }

    public int getResignD12() {
        return resignD12;
    }

    public int getOnboardD13() {
        return onboardD13;
    }

    public int getResignD13() {
        return resignD13;
    }

    public int getOnboardD14() {
        return onboardD14;
    }

    public int getResignD14() {
        return resignD14;
    }

    public int getOnboardD15() {
        return onboardD15;
    }

    public int getResignD15() {
        return resignD15;
    }

    public int getOnboardD16() {
        return onboardD16;
    }

    public int getResignD16() {
        return resignD16;
    }

    public int getOnboardD17() {
        return onboardD17;
    }

    public int getResignD17() {
        return resignD17;
    }

    public int getOnboardD18() {
        return onboardD18;
    }

    public int getResignD18() {
        return resignD18;
    }

    public int getOnboardD19() {
        return onboardD19;
    }

    public int getResignD19() {
        return resignD19;
    }

    public int getOnboardD20() {
        return onboardD20;
    }

    public int getResignD20() {
        return resignD20;
    }

    public int getOnboard3rd10Ds() {
        return onboard3rd10Ds;
    }

    public int getResign3rd10Ds() {
        return resign3rd10Ds;
    }

    public int getOnboardD21() {
        return onboardD21;
    }

    public int getResignD21() {
        return resignD21;
    }

    public int getOnboardD22() {
        return onboardD22;
    }

    public int getResignD22() {
        return resignD22;
    }

    public int getOnboardD23() {
        return onboardD23;
    }

    public int getResignD23() {
        return resignD23;
    }

    public int getOnboardD24() {
        return onboardD24;
    }

    public int getResignD24() {
        return resignD24;
    }

    public int getOnboardD25() {
        return onboardD25;
    }

    public int getResignD25() {
        return resignD25;
    }

    public int getOnboardD26() {
        return onboardD26;
    }

    public int getResignD26() {
        return resignD26;
    }

    public int getOnboardD27() {
        return onboardD27;
    }

    public int getResignD27() {
        return resignD27;
    }

    public int getOnboardD28() {
        return onboardD28;
    }

    public int getResignD28() {
        return resignD28;
    }

    public int getOnboardD29() {
        return onboardD29;
    }

    public int getResignD29() {
        return resignD29;
    }

    public int getOnboardD30() {
        return onboardD30;
    }

    public int getResignD30() {
        return resignD30;
    }

    public int getOnboardD31() {
        return onboardD31;
    }

    public int getResignD31() {
        return resignD31;
    }

    public int getOnboard() {
        return onboard;
    }

    public int getResign() {
        return resign;
    }

    public static class Builder {
        private String company;
        private String city;
        private String district;
        private String branch;
        private String creatorName;
        private String month;
        private int onboard1st10Ds;
        private int resign1st10Ds;
        private int onboardD1;
        private int resignD1;
        private int onboardD2;
        private int resignD2;
        private int onboardD3;
        private int resignD3;
        private int onboardD4;
        private int resignD4;
        private int onboardD5;
        private int resignD5;
        private int onboardD6;
        private int resignD6;
        private int onboardD7;
        private int resignD7;
        private int onboardD8;
        private int resignD8;
        private int onboardD9;
        private int resignD9;
        private int onboardD10;
        private int resignD10;
        private int onboard2nd10Ds;
        private int resign2nd10Ds;
        private int onboardD11;
        private int resignD11;
        private int onboardD12;
        private int resignD12;
        private int onboardD13;
        private int resignD13;
        private int onboardD14;
        private int resignD14;
        private int onboardD15;
        private int resignD15;
        private int onboardD16;
        private int resignD16;
        private int onboardD17;
        private int resignD17;
        private int onboardD18;
        private int resignD18;
        private int onboardD19;
        private int resignD19;
        private int onboardD20;
        private int resignD20;
        private int onboard3rd10Ds;
        private int resign3rd10Ds;
        private int onboardD21;
        private int resignD21;
        private int onboardD22;
        private int resignD22;
        private int onboardD23;
        private int resignD23;
        private int onboardD24;
        private int resignD24;
        private int onboardD25;
        private int resignD25;
        private int onboardD26;
        private int resignD26;
        private int onboardD27;
        private int resignD27;
        private int onboardD28;
        private int resignD28;
        private int onboardD29;
        private int resignD29;
        private int onboardD30;
        private int resignD30;
        private int onboardD31;
        private int resignD31;
        private int onboard;
        private int resign;

        public Builder() {}

        public Builder(String creatorName, Object[][] onboardCounts, Object[][] resignCounts, String yearAndMonth) {
            this.creatorName=creatorName;
            this.month=yearAndMonth;
            initCounts(onboardCounts, resignCounts, yearAndMonth);
        }

        public Builder(Branch branch, Object[][] onboardCounts, Object[][] resignCounts, String yearAndMonth) {
            this.company=branch.getCompany().getName();
            this.city=branch.getCompany().getCity();
            this.district=branch.getDistrict();
            this.branch=branch.getName();
            this.month=yearAndMonth;
            initCounts(onboardCounts, resignCounts, yearAndMonth);
        }

        private void initCounts(Object[][] onboardCounts, Object[][] resignCounts, String yearAndMonth) {
            Map<String, Integer> onboards = new HashMap<>();
            for (Object[] count : onboardCounts) {
                onboards.put((String)count[0], ((Long)count[1]).intValue());
            }
            Map<String, Integer> resigns = new HashMap<>();
            for (Object[] count : resignCounts) {
                resigns.put((String)count[0], ((Long)count[1]).intValue());
            }
            this.onboardD1 = getCount(onboards, yearAndMonth, "01");
            this.onboardD2 = getCount(onboards, yearAndMonth, "02");
            this.onboardD3 = getCount(onboards, yearAndMonth, "03");
            this.onboardD4 = getCount(onboards, yearAndMonth, "04");
            this.onboardD5 = getCount(onboards, yearAndMonth, "05");
            this.onboardD6 = getCount(onboards, yearAndMonth, "06");
            this.onboardD7 = getCount(onboards, yearAndMonth, "07");
            this.onboardD8 = getCount(onboards, yearAndMonth, "08");
            this.onboardD9 = getCount(onboards, yearAndMonth, "09");
            this.onboardD10 = getCount(onboards, yearAndMonth, "10");
            this.onboard1st10Ds = onboardD1 + onboardD2 + onboardD3 + onboardD4 + onboardD5 + onboardD6 + onboardD7 + onboardD8 + onboardD9 + onboardD10;

            this.onboardD11 = getCount(onboards, yearAndMonth, "11");
            this.onboardD12 = getCount(onboards, yearAndMonth, "12");
            this.onboardD13 = getCount(onboards, yearAndMonth, "13");
            this.onboardD14 = getCount(onboards, yearAndMonth, "14");
            this.onboardD15 = getCount(onboards, yearAndMonth, "15");
            this.onboardD16 = getCount(onboards, yearAndMonth, "16");
            this.onboardD17 = getCount(onboards, yearAndMonth, "17");
            this.onboardD18 = getCount(onboards, yearAndMonth, "18");
            this.onboardD19 = getCount(onboards, yearAndMonth, "19");
            this.onboardD20 = getCount(onboards, yearAndMonth, "20");
            this.onboard2nd10Ds = onboardD11 + onboardD12 + onboardD13 + onboardD14 + onboardD15 + onboardD16 + onboardD17 + onboardD18 + onboardD19 + onboardD20;

            this.onboardD21 = getCount(onboards, yearAndMonth, "21");
            this.onboardD22 = getCount(onboards, yearAndMonth, "22");
            this.onboardD23 = getCount(onboards, yearAndMonth, "23");
            this.onboardD24 = getCount(onboards, yearAndMonth, "24");
            this.onboardD25 = getCount(onboards, yearAndMonth, "25");
            this.onboardD26 = getCount(onboards, yearAndMonth, "26");
            this.onboardD27 = getCount(onboards, yearAndMonth, "27");
            this.onboardD28 = getCount(onboards, yearAndMonth, "28");
            this.onboardD29 = getCount(onboards, yearAndMonth, "29");
            this.onboardD30 = getCount(onboards, yearAndMonth, "30");
            this.onboardD31 = getCount(onboards, yearAndMonth, "31");
            this.onboard3rd10Ds = onboardD21 + onboardD22 + onboardD23 + onboardD24 + onboardD25 + onboardD26 + onboardD27 + onboardD28 + onboardD29 + onboardD30 + onboardD31;

            this.onboard = onboard1st10Ds + onboard2nd10Ds + onboard3rd10Ds;

            this.resignD1 = getCount(resigns, yearAndMonth, "01");
            this.resignD2 = getCount(resigns, yearAndMonth, "02");
            this.resignD3 = getCount(resigns, yearAndMonth, "03");
            this.resignD4 = getCount(resigns, yearAndMonth, "04");
            this.resignD5 = getCount(resigns, yearAndMonth, "05");
            this.resignD6 = getCount(resigns, yearAndMonth, "06");
            this.resignD7 = getCount(resigns, yearAndMonth, "07");
            this.resignD8 = getCount(resigns, yearAndMonth, "08");
            this.resignD9 = getCount(resigns, yearAndMonth, "09");
            this.resignD10 = getCount(resigns, yearAndMonth, "10");
            this.resign1st10Ds = resignD1 + resignD2 + resignD3 + resignD4 + resignD5 + resignD6 + resignD7 + resignD8 + resignD9 + resignD10;

            this.resignD11 = getCount(resigns, yearAndMonth, "11");
            this.resignD12 = getCount(resigns, yearAndMonth, "12");
            this.resignD13 = getCount(resigns, yearAndMonth, "13");
            this.resignD14 = getCount(resigns, yearAndMonth, "14");
            this.resignD15 = getCount(resigns, yearAndMonth, "15");
            this.resignD16 = getCount(resigns, yearAndMonth, "16");
            this.resignD17 = getCount(resigns, yearAndMonth, "17");
            this.resignD18 = getCount(resigns, yearAndMonth, "18");
            this.resignD19 = getCount(resigns, yearAndMonth, "19");
            this.resignD20 = getCount(resigns, yearAndMonth, "20");
            this.resign2nd10Ds = resignD11 + resignD12 + resignD13 + resignD14 + resignD15 + resignD16 + resignD17 + resignD18 + resignD19 + resignD20;

            this.resignD21 = getCount(resigns, yearAndMonth, "21");
            this.resignD22 = getCount(resigns, yearAndMonth, "22");
            this.resignD23 = getCount(resigns, yearAndMonth, "23");
            this.resignD24 = getCount(resigns, yearAndMonth, "24");
            this.resignD25 = getCount(resigns, yearAndMonth, "25");
            this.resignD26 = getCount(resigns, yearAndMonth, "26");
            this.resignD27 = getCount(resigns, yearAndMonth, "27");
            this.resignD28 = getCount(resigns, yearAndMonth, "28");
            this.resignD29 = getCount(resigns, yearAndMonth, "29");
            this.resignD30 = getCount(resigns, yearAndMonth, "30");
            this.resignD31 = getCount(resigns, yearAndMonth, "31");
            this.resign3rd10Ds = resignD21 + resignD22 + resignD23 + resignD24 + resignD25 + resignD26 + resignD27 + resignD28 + resignD29 + resignD30 + resignD31;

            this.resign = resign1st10Ds + resign2nd10Ds + resign3rd10Ds;
        }

        private int getCount(Map<String, Integer> counts, String month, String day) {
            String dateString = month + "-" + day;
            return counts.get(dateString) == null? 0 : counts.get(dateString);
        }

        public ApplicationReportDTO build() {
            return new ApplicationReportDTO(this);
        }
    }

}
