package model;

public class Move {

    private  String name,type,descrption,des,link;
            private int image;



    public Move(String name, String type, String descrption,int  image,String des,String link) {
        this.name = name;
        this.type = type;
        this.descrption = descrption;
        this.image=image;
        this.des=des;
        this.link=link;
    }

    public void setDes(String des) {

        this.des = des;
    }

    public String getDes() {
        return des;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }
}
