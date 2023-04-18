public class MedaillePays {
    public int medailles;
    public String pays;

    public MedaillePays(int medailles, String pays){
        this.medailles=medailles;
        this.pays=pays;
    }

    public int compareTo(MedaillePays mp){
        return this.medailles-mp.medailles;
    }

    public String toString(){
        return this.pays+" : "+this.medailles+" medaille(s)";
    }
}
