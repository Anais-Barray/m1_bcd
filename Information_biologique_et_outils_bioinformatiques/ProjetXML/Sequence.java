import java.util.*;

public class Sequence
{
        private String  numAcc ;
        private String  organism ;
        private Set lesFeatures = new HashSet();

        // Constructeur vide requis
        public Sequence(){}

        public Sequence(String numAcc, String organism ){
                this.numAcc = numAcc;
                this.organism = organism;
        }

        public String getNumAcc(){return numAcc;}
        public String getOrganism(){return organism;}
        public Set getLesFeatures(){return lesFeatures;}

        public void setNumAcc(String numAcc)
        {this.numAcc = numAcc;}
        public void setOrganism(String organism){this.organism = organism;}

        // Gestion explicite des associations par attributs
        public void setLesFeatures(Set lesFeatures ){
                this.lesFeatures = lesFeatures ;
        }
}