/**
 * Tämän luokan tarkoitus on tulostaa käyttöliittymä pelaajalle
 * sekä lukea pelaajan syötetty ja välittää se Controllerille
 * Tässä versiossa on tekstipohjainen käyttöliittymä, joka ei juuri tällä hetkellä toimi
 * Tekstipohjainen käyttöliittymä kuitenkin korvataan graafisella käyttöliittymällä
 * Heti kun saamme pohjan sille aikaiseksi
 * Tekstipohjaisella käyttöliittymällä pystymme testaamaan valmiina olevia metodeja
 */
package rallimeister5000;

import java.util.Scanner;

public class Ui {
    private Controller kontti;
    private Scanner lukija = new Scanner(System.in);
    
    public Ui(Controller kontti) {
        this.kontti = kontti;
    }

    void päivitä(int state) {
        do {
            int komento;
            if (state == 0) {
                System.out.println("1. uusi peli");
                System.out.println("2. Sarja testikomentoja");
                System.out.println("3. Kunhan vaan on");
                System.out.println("4. Lopeta");
                komento = lukija.nextInt();
                switch(komento) {
                    case 1:
                        lukija.nextLine();
                        System.out.println("Anna nimesi");
                        String pelaaja = lukija.nextLine();
                        break;
                    case 2:
                        System.out.println(kontti.ralliSarjat[0].getNimi());
                        System.out.println(kontti.ralliSarjat[1].getNimi());
                        System.out.println(kontti.ralliSarjat[2].getNimi());
                        System.out.println(kontti.ralliSarjat[3].getNimi());
                        System.out.println(kontti.ralliSarjat[4].getNimi());
                        System.out.println(kontti.ralliSarjat[0].getTallit().length);
                        System.out.println(kontti.ralliSarjat[1].getTallit().length);
                        System.out.println(kontti.ralliSarjat[2].getTallit().length);
                        System.out.println(kontti.ralliSarjat[3].getTallit().length);
                        System.out.println(kontti.ralliSarjat[4].getTallit().length);
                        for (int i = 0; i < 5; i++) {
                            System.out.println(kontti.ralliSarjat[i].getNimi());
                            Talli[] tallit = kontti.ralliSarjat[i].getTallit();
                            System.out.println(tallit.length);
                            System.out.println(tallit[0].getNimi());
                            System.out.println(tallit[1].getNimi());
                            System.out.println(tallit[2].getNimi());
                            System.out.println(tallit[3].getNimi());
                        }
                        for (int i = 0; i < kontti.ralliSarjat.length - 1; i++) {
                            for (int a = 0; a < kontti.ralliSarjat[i].getTallit().length; a++) {
                                System.out.println(kontti.ralliSarjat[i].getTallit()[0].getOmistaja().getNimi());
                            }
                        }

                        for (int i = 0; i < 5; i++) {
                            for (int a = 0; a < 4; a++) {
                                System.out.println(kontti.ralliSarjat[i].getTallit()[a].getYkkoskuski().getNimi());
                                System.out.println(kontti.ralliSarjat[i].getTallit()[a].getKakkoskuski().getNimi());
                            }

                            for (int o = 0; o < kontti.getVapaatMekaanikot().size(); o++) {
                                System.out.println(kontti.getVapaatMekaanikot().get(i).getNimi() + " " + kontti.getVapaatMekaanikot().get(i).getTaito());
                            }
                            for (int o = 0; o < kontti.getVapaatManagerit().size(); o++) {
                                System.out.println(kontti.getVapaatManagerit().get(i).getNimi() + " " + kontti.getVapaatManagerit().get(i).getNeuvotteluTaito());
                            }

                        }
                        kontti.ralliSarjat[0].getTallit()[0].setVarallisuus(50000);
                        for (int x = 0; x < 10; x++) {
                            kontti.ralliSarjat[0].getTallit()[0].ostaMoottori(kontti.getOsat(), 0);
                            System.out.println(kontti.ralliSarjat[0].getTallit()[0].getMoottorit()[x].getNimi());
                            kontti.ralliSarjat[0].getTallit()[0].ostaJarrut(kontti.getOsat(), 0);
                            System.out.println(kontti.ralliSarjat[0].getTallit()[0].getJarrut()[x].getNimi());
                            kontti.ralliSarjat[0].getTallit()[0].ostaJouset(kontti.getOsat(), 0);
                            System.out.println(kontti.ralliSarjat[0].getTallit()[0].getJouset()[x].getNimi());
                            kontti.ralliSarjat[0].getTallit()[0].ostaRenkaat(kontti.getOsat(), 0);
                            System.out.println(kontti.ralliSarjat[0].getTallit()[0].getRenkaat()[x].getNimi());
                            System.out.println(kontti.ralliSarjat[0].getTallit()[0].getVarallisuus());
                            kontti.ralliSarjat[0].getTallit()[0].ostaAuto(kontti.getOsat(), 0);
                            System.out.println(kontti.ralliSarjat[0].getTallit()[0].getAutot()[x].getMerkki());
                            System.out.println(kontti.ralliSarjat[0].getTallit()[0].getVarallisuus());
                        }
                        System.out.println(kontti.getOsat().getMoottorit()[0].getNimi());
                        System.out.println(kontti.getOsat().getJarrut()[0].getNimi());
                        System.out.println(kontti.getOsat().getJousitukset()[0].getNimi());
                        System.out.println(kontti.getOsat().getRenkaat()[0].getNimi());
                        System.out.println(kontti.getOsat().getAutot()[0].getMerkki());
                        break;
                    case 3:

                        break;
                    case 4:
                        kontti.setState(-1);
                        System.out.println("Lopetetaan peli....");
                        break;
                    case 5:
                        for (int sarja = 0; sarja < kontti.ralliSarjat.length; sarja++) {
                            System.out.println(kontti.ralliSarjat[sarja].getNimi());
                            System.out.println(kontti.ralliSarjat.length);
                            for (int talli = 0; talli < kontti.ralliSarjat[sarja].getTallit().length; talli++) {
                                System.out.println(kontti.ralliSarjat[sarja].getTallit()[talli].getNimi());
                                System.out.println(kontti.ralliSarjat[sarja].getTallit().length);
                            }
                        }
                        
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("En ymmärtänyt syötettä!");
                }
            }
            if (state == 1) {
                System.out.println("Tervetuloa Rallimeister5000 pariin, "+kontti.pelaajantalli.getOmistaja().getNimi()+"!");
                komento = lukija.nextInt();
                switch(komento) {
                    case 1:
                        break;
                    case 2: 
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                        
                }
            }
            if (state == 2) {
                komento = lukija.nextInt();
                switch(komento) {
                    case 1:
                        break;
                    case 2: 
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                        
                }
            }
            if (state == 3) {
                komento = lukija.nextInt();
                switch(komento) {
                    case 1:
                        break;
                    case 2: 
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                        
                }
            }
            if (state == 4) {
                komento = lukija.nextInt();
                switch(komento) {
                    case 1:
                        break;
                    case 2: 
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                        
                }
            }
            if (state == 5) {
                komento = lukija.nextInt();
                switch(komento) {
                    case 1:
                        break;
                    case 2: 
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                        
                }
            }
        } while (kontti.getState() != -1);
            
    }
}


                    