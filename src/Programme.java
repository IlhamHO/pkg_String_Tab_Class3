import eu.epfc.prm2.Array;

import java.util.ArrayList;

public class Programme {
    public static boolean estPresent(Array<MedaillePays> mp, String pays){
        for(int i=0; i<mp.size();++i){
            if(mp.get(i).pays.compareTo(pays)==0) return true;
        }
        return false;
    }

    public static int pos(Array<MedaillePays>mp, MedaillePays md){
        int i=0;
        while (i< mp.size() && mp.get(i).compareTo(md)>0){
            ++i;
        }
        return i;
    }

    public static void ajouter(Array<MedaillePays>mp,MedaillePays m ){
        mp.add(m);
        for(int i=mp.size()-1;i>pos(mp,m);--i){
            mp.set(i,mp.get(i-1));
        }
        mp.set(pos(mp,m),m);
    }

    public static int getMedaille(Array<MedaillePays>mp, String pays){
        int md =1;
        for(int i=0;i<mp.size();++i) {
            if (mp.get(i).pays.compareTo(pays) == 0) {
                md=mp.get(i).medailles;
            }
        }
        return md;
    }


    public static void affiche(Array<MedaillePays> medailles) {
        System.out.println("Médailles des pays :");
        for (MedaillePays m : medailles) {
            System.out.println(m);
        }
        System.out.println("============================================");
    }

    public static void nouvelleMedaille(Array<MedaillePays>mp,String pays){
        if(mp.isEmpty()) mp.add(new MedaillePays(1,pays));
        else if(!estPresent(mp,pays)){
            MedaillePays newMp = new MedaillePays(1,pays);

            ajouter(mp,newMp);
        } else {
            int md=getMedaille(mp,pays);
            ++md;
            MedaillePays newMp= new MedaillePays(md,pays);
            int index=0;
            for(int i=0; i<mp.size();++i){
                if(mp.get(i).pays.compareTo(pays)!=0){
                    mp.set(index,mp.get(i));
                    ++index;
                }
            }
            mp.reduceTo(index);
            if(!estPresent(mp,pays)) ajouter(mp,newMp);

        }

    }
    public static void main(String[] args) {
        Array<MedaillePays> medailles = new Array<>();
        nouvelleMedaille(medailles, "Belgique");
        affiche(medailles);
        nouvelleMedaille(medailles, "France");
        affiche(medailles);
        nouvelleMedaille(medailles, "France");
        affiche(medailles);
        nouvelleMedaille(medailles, "Allemagne");
        affiche(medailles);
        nouvelleMedaille(medailles, "Belgique");
        affiche(medailles);
        nouvelleMedaille(medailles, "Belgique");
        affiche(medailles);
    }
}