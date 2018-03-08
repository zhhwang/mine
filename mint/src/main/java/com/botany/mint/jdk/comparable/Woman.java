package com.botany.mint.jdk.comparable;

/**
 * @author wangzh
 */
public class Woman {

    private String favorite;

    private PersonComparable personComparable;

    public Woman(String favorite, PersonComparable personComparable) {
        this.favorite = favorite;
        this.personComparable = personComparable;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public PersonComparable getPersonComparable() {
        return personComparable;
    }

    public void setPersonComparable(PersonComparable personComparable) {
        this.personComparable = personComparable;
    }
}
