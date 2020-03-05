package net.mc.tools.models.branding.request;

public class UpdateBrandingOfSellerRequestModel {

    private String loginText;

    private String color;

    private String headerFont;

    private String footer;

    private String buttonColor;

    private String domain;

    private String logo;

    private String buttonFont;

    private String hideMcContactInfo;

    private String emailSign;

    private Register register;

    public String getLoginText ()
    {
        return loginText;
    }

    public void setLoginText (String loginText)
    {
        this.loginText = loginText;
    }

    public String getColor ()
    {
        return color;
    }

    public void setColor (String color)
    {
        this.color = color;
    }

    public String getHeaderFont ()
    {
        return headerFont;
    }

    public void setHeaderFont (String headerFont)
    {
        this.headerFont = headerFont;
    }

    public String getFooter ()
    {
        return footer;
    }

    public void setFooter (String footer)
    {
        this.footer = footer;
    }

    public String getButtonColor ()
    {
        return buttonColor;
    }

    public void setButtonColor (String buttonColor)
    {
        this.buttonColor = buttonColor;
    }

    public String getDomain ()
    {
        return domain;
    }

    public void setDomain (String domain)
    {
        this.domain = domain;
    }

    public String getLogo ()
    {
        return logo;
    }

    public void setLogo (String logo)
    {
        this.logo = logo;
    }

    public String getButtonFont ()
    {
        return buttonFont;
    }

    public void setButtonFont (String buttonFont)
    {
        this.buttonFont = buttonFont;
    }

    public String getHideMcContactInfo ()
    {
        return hideMcContactInfo;
    }

    public void setHideMcContactInfo (String hideMcContactInfo)
    {
        this.hideMcContactInfo = hideMcContactInfo;
    }

    public String getEmailSign ()
    {
        return emailSign;
    }

    public void setEmailSign (String emailSign)
    {
        this.emailSign = emailSign;
    }

    public Register getRegister ()
    {
        return register;
    }

    public void setRegister (Register register)
    {
        this.register = register;
    }

}
