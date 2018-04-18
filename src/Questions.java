

public class Questions {
    private String city;
    private String Country;
    private String URL;

    public Questions(String city, String Country, String URL){
        setCity(city);
        setCountry(Country);
        setURL(URL);
    }
    //Constructor for "Question" class
    public Questions(){
        city = "";
        Country = "";
        URL = "";
    }
    //Getters and setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    //Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Questions questions = (Questions) o;

        if (city != null ? !city.equals(questions.city) : questions.city != null) return false;
        if (Country != null ? !Country.equals(questions.Country) : questions.Country != null) return false;
        return URL != null ? URL.equals(questions.URL) : questions.URL == null;
    }
    //To string method
    @Override
    public String toString() {
        return "Questions{" + "city='" + city + '\'' + ", Country='" + Country + '\'' + ", URL='" + URL + '\'' + '}';
    }

}
