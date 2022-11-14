public class Data {

//    private String login;
//    private String password;
//    private String confirmPassword;

//    public Data(String login, String password, String confirmPassword) {
//        this.login = login;
//        this.password = password;
//        this.confirmPassword = confirmPassword;
//    }

    public static boolean loginPasswordCheck(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!stringCorrect(login)) {
            throw new WrongLoginException("Логин указан не верно!");
        }
        if (stringCorrect(password) && password.equals(confirmPassword)) {
            System.out.println("Логин и пароль указаны корректно!");
        }else{
            throw new WrongPasswordException("Пароль указан не верно, либо они не сопадают!");
        }
        return true;
    }

    private static boolean stringCorrect(String checkString){

        if (checkString == null
                || checkString.isEmpty()
                || checkString.isBlank()
                || checkString.length() > 20) {
            return false;
        }

        final String validСhar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";

        for (int i = 0; i < checkString.length(); i++) {
            if (validСhar.indexOf(checkString.charAt(i)) < 0) {
                return false;
            }
        }
        return true;
    }
}
