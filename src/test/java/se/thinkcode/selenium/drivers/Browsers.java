package se.thinkcode.selenium.drivers;

public enum Browsers {

    FIREFOX, CHROME, HTML_UNIT;

    public String toString() {
        if (this.equals(FIREFOX))
            return "Firefox";
        else if (this.equals(CHROME))
            return "Chrome";
        else
            return "Html_Unit";
    }
}
