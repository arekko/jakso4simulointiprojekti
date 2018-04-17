
package rallimeister5000;


class AI {
    
    Talli talli;
    private Controller kontti;
    AI(Controller kontti) {
        this.kontti = kontti;
    }
    public void alustaTallit(Talli talli) {
        /*int persoona = talli.getOmistaja().getPersoonallisuus();
        double varallisuus = talli.getVarallisuus();
        this.talli = talli;
        kontti.getVapaatManagerit();
        if (persoona == 1) {
     
        }

        if (persoona == 2) {

        }
        
        if (persoona == 3) {
            
        }
        
        if (persoona == 4) {
            
        }
        */
        System.out.println("AiAiAi");
     
    }
    
    double hankiManageri(int persoona, double varallisuus) {
        Manageri manageri = null;
        int edellinen = 0;
        int indeksi = 0;
        for (int i = 0; i < kontti.getVapaatManagerit().size(); i++) {
            if (kontti.getVapaatManagerit().get(i).getNeuvotteluTaito() > edellinen) {
                edellinen = kontti.getVapaatManagerit().get(i).getNeuvotteluTaito();
                manageri = kontti.getVapaatManagerit().get(i);
                indeksi = i;
            }
            if (manageri != null && talli.getVarallisuus() > kontti.getVapaatManagerit().get(indeksi).getHankintaHinta() + 2000) {
                talli.ostaManageri(manageri);
                return 1;
            }
        }
        return 0;
    }
    
    boolean hankiYkkoskuski (int persoona, double varallisuus) {
        if (persoona == 1) {
            return true;
        }
        if (persoona == 2) {
            return true;
        }
        if (persoona == 3) {
            return true;
        }
        if (persoona == 4) {
            return true;
        }
        return false;
    }
    
    boolean hankiKakkosKuski (int persoona, double varallisuus) {
        if (persoona == 1) {
            return true;
        }
        if (persoona == 2) {
            return true;
        }
        if (persoona == 3) {
            return true;
        }
        if (persoona == 4) {
            return true;
        }
        return false;
    }
    
    boolean hankiAutot (int persoona, double varallisuus) {
        if (persoona == 1) {
            return true;
        }
        if (persoona == 2) {
            return true;
        }
        if (persoona == 3) {
            return true;
        }
        if (persoona == 4) {
            return true;
        }
        return false;
    }
    
    void paivitaOsia(int persoona, double varallisuus) {
        if (persoona == 1) {
            
        }
        if (persoona == 2) {
            
        }
        if (persoona == 3) {
            
        }
        if (persoona == 4) {
            
        }
    }
    
    void hommaaSponsoreita(int persoona, double varallisuus) {
        
    }
}
