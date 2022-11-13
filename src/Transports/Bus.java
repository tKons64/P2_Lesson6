package Transports;

public class Bus extends Transport implements Competable{

    public enum Capacity{

        EXTRA_SMALL("до 10 мест"),        //до 10 мест
        SMALL("до 25 мест"),              //до 25
        MEDIUM("40–50 мест"),             //40–50
        LARGE("60–80 мест"),              //60–80
        ESPECIALLY_LARGE("100–120 мест"); //100–120 мест
        private String comment;

        Capacity(String comment) {
            this.comment = comment;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }

    private Capacity type;

    public Bus(String brand, String model, int engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void pitStop() {
        System.out.println("Пит-стоп");
    }

    @Override
    public int bestLapTime() {
        return 10;
    }

    @Override
    public int maxSpeed() {
        return 80;
    }

    public Capacity getType() {
        return type;
    }

    public void setType(Capacity type) {
        this.type = type;
    }

    public String printType() {
        if (type == null) {
            return "*Тип авто не определен*";
        } else {
            return type.getComment();
        }
    }
}
