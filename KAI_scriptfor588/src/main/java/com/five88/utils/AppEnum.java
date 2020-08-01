package com.five88.utils;

public class AppEnum {

    public enum DriverType {
        CHROME, FIREFOX, SAFARI;
    }

    public enum ChannelType {
        FIVE88_BUG_GROUP("-316205011"),
        AUTO_TOOL_DEBUG_GROUP("-377930183");
        // AUTO_CRASH_TRACKING_GROUP("-300681367");

        private final String text;

        /**
         * @param text
         */
        ChannelType(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    public enum KenoType {
        QUICK_KENO_1("kn-1"),
        QUICK_KENO_2("kn-2"),
        MAX_KENO_1("kn-20"),
        MAX_KENO_2("kn-21"),
        XUAN("kn-22"),
        HA("kn-23"),
        THU("kn-24"),
        DONG("kn-25");

        private final String text;

        /**
         * @param text
         */
        KenoType(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    public enum GameType {
        FEATURE_GAME("1"),
        TABLES_GAME("2"),
        SLOTS_GAME("3"),
        OTHER_GAME("4");

        private final String text;

        /**
         * @param text
         */
        GameType(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }

    public enum FeatureGameType {
        AN_KHE_TRA_VANG("https://five88.com/slot.aspx?gid=kts9998"),
        SON_TINH_THUY_TINH("https://five88.com/slot.aspx?gid=kts9999"),
        MY_NU("https://five88.com/slot.aspx?gid=kts9996"),
        TRUNG_THU("https://five88.com/slot.aspx?gid=kts9993"),
        BAN_CA("https://five88.com/fishing/play.aspx"),
        BACCARAT_NHO(""),
        XI_DZACH_BAN_DON_MH(""),
        TO_CHUC_SONG_BAC(""),
        SIEU_BANH_XE(""),
        ROULETTE_CHAU_AU(""),
        XI_DACH_CHAU_AU_DOI_MH(""),
        SAN_ANH_HOANG_DA(""),
        KIM_CUONG_MAY_MAN("");

        private final String text;

        /**
         * @param text
         */
        FeatureGameType(final String text) {
            this.text = text;
        }

        /* (non-Javadoc)
         * @see java.lang.Enum#toString()
         */
        @Override
        public String toString() {
            return text;
        }
    }
}
