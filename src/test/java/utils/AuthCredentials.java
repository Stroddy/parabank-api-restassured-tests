package utils;

public class AuthCredentials {
    private AuthCredentials(){}
        public static String username(){
        String v= System.getenv("PARABANK_USERNAME");
        if (v==null || v.isBlank()){
            throw new IllegalStateException("Username is not set");
        }
        return v;
        }

        public static String password(){
        String v = System.getenv("PARABANK_PASSWORD");
        if (v==null || v.isBlank()){
            throw new IllegalStateException("Password is not set");
        }

        return v;
        }


}
