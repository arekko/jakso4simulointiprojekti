package maxattak.Model;

public class OsatInfo {

    private String moottoriInfo;
    private String jarrutInfo;
    private String turboInfo ;
    private String vaihdelaatikoInfo;
    private String jousitusInfo;
    private String rengasInfo;



    public OsatInfo(){
        this.moottoriInfo = "Lorem ipsum dolor sit amet, dolores eligendi suscipiantur an ius. Sea sint aliquip necessitatibus id. Eruditi epicurei pro id, meis pertinax in qui. Id aeque doming neglegentur sit.";
        jarrutInfo = "Lorem ipsum dolor sit amet, dolores eligendi suscipiantur an ius. Sea sint aliquip necessitatibus id. Eruditi epicurei pro id, meis pertinax in qui. Id aeque doming neglegentur sit.";
        turboInfo = "Lorem ipsum dolor sit amet, dolores eligendi suscipiantur an ius. Sea sint aliquip necessitatibus id. Eruditi epicurei pro id, meis pertinax in qui. Id aeque doming neglegentur sit.";
        vaihdelaatikoInfo = "Lorem ipsum dolor sit amet, dolores eligendi suscipiantur an ius. Sea sint aliquip necessitatibus id. Eruditi epicurei pro id, meis pertinax in qui. Id aeque doming neglegentur sit.";
        jousitusInfo = "Lorem ipsum dolor sit amet, dolores eligendi suscipiantur an ius. Sea sint aliquip necessitatibus id. Eruditi epicurei pro id, meis pertinax in qui. Id aeque doming neglegentur sit.";
        rengasInfo = "Lorem ipsum dolor sit amet, dolores eligendi suscipiantur an ius. Sea sint aliquip necessitatibus id. Eruditi epicurei pro id, meis pertinax in qui. Id aeque doming neglegentur sit.";
    }
    //getterit

    public String getMoottoriInfo(){
        return this.moottoriInfo;
    }
    public String getJarrutInfo(){
        return this.jarrutInfo;
    }
    public String getTurboInfo(){
        return this.turboInfo;
    }
    public String getVaihdelaatikoInfo(){
        return this.vaihdelaatikoInfo;
    }
    public String getJousitusInfo(){
        return this.jousitusInfo;
    }
    public String getRengasInfo(){
        return this.rengasInfo;
    }

    //setterit

    public void setVaihdelaatikoInfo(String vaihdelaatikoInfo) {
        this.vaihdelaatikoInfo = vaihdelaatikoInfo;
    }

    public void setTurboInfo(String turboInfo) {
        this.turboInfo = turboInfo;
    }

    public void setRengasInfo(String rengasInfo) {
        this.rengasInfo = rengasInfo;
    }

    public void setMoottoriInfo(String moottoriInfo) {
        this.moottoriInfo = moottoriInfo;
    }

    public void setJousitusInfo(String jousitusInfo) {
        jousitusInfo = jousitusInfo;
    }

    public void setJarrutInfo(String jarrutInfo) {
        this.jarrutInfo = jarrutInfo;
    }
}
