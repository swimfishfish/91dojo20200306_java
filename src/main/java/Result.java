public class Result {

    String name;
    Category category;
    Integer point;

    @Override
    public String toString() {
        if ( this.category == Category.NO_POINT) {
            return "Tie";
        }
        else  if (this.category == Category.ALL_THE_SAME_KIND) {
            if (point == null) {
                return "Tie";
            }
            return this.name + " wins. all the same kind:" + this.point;
        }
        else{//Normal Point
            if(point == null){
                return "Tie";
            }
            return this.name + " wins. normal point:" + this.point;
        }
    }
}
