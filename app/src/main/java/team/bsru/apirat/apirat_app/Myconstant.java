package team.bsru.apirat.apirat_app;

/**
 * Created by ikool009 on 19/2/2560.
 */

public class Myconstant {
    private String serviceCreateUser = "http://tait.bsruteam.tk/Service_php_for_android/service/createUser.php?";
    private String serverDomain = "http://tait.bsruteam.tk/Service_php_for_android/";
    private String serviceLogin = "http://tait.bsruteam.tk/Service_php_for_android/service/ServiceLogin.php?";
    private String serviceShowListDate = "http://tait.bsruteam.tk/Service_php_for_android/service/get_list_detail.php?";
    private String servicegetOverview = "http://tait.bsruteam.tk/Service_php_for_android/service/getOverview.php?";

    public String getServiceCreateUser() {
        return serviceCreateUser;
    }

    public String getServerDomain() {
        return serverDomain;
    }

    public String getServiceLogin() {
        return serviceLogin;
    }

    public String getServiceShowListDate() {
        return serviceShowListDate;
    }

    public String getServicegetOverview() {
        return servicegetOverview;
    }
}
