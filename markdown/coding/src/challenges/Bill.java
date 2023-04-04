package challenges;

import java.util.ArrayList;
import java.util.Date;

public class Bill {

    public String customerName;
    public String nickname;
    public Date birthday;
    public String email;
    public String street;
    public String streetNumber;
    public int postalCode;
    public String city;
    public ArrayList<Article> articles;

    public Bill(String cn, String n, String s, String sn, int pc, Date b, String e, String c) {
        customerName = cn;
        nickname = n;
        street = s;
        streetNumber = sn;
        postalCode = pc;
        birthday = b;
        email = e;
        city = c;
        articles = new ArrayList<Article>();
    }

    public boolean addArticle(Article a) {
        return articles.add(a);
    }

    public String getDetails() {
        double total = 0;

        String result = "Details for \"" + customerName + "\"\n";
        result += street + " " + streetNumber + "\n";
        result += postalCode + " " + city + "\n";
        result += "Geburtstag: " + birthday + "\n";
        result += "Email: " + email + "\n\n";
        result += "Article: \n";
        for (Article article : articles) {
            double price = 0;
            if (article.bike instanceof Brompton) {
                if (article.purchaseAmount > 1) {
                    price += (article.purchaseAmount - 1) * article.bike.price / 2;
                }
                price += article.bike.price * article.purchaseAmount;
            } else if (article.bike instanceof EBike) {
                price += article.bike.price * article.purchaseAmount;
            } else if (article.bike instanceof Mountainbike) {
                if (article.purchaseAmount > 2) {
                    price += article.purchaseAmount * article.bike.price * 9 / 10;
                } else {
                    price += article.bike.price * article.purchaseAmount;
                }
            }
            if (price > 1000f || price == 1000.0) {
                price = price * 0.8;
            }

            result += "\t" + article.bike.productName + "\tx\t" + article.purchaseAmount + "\t=\t" + String.valueOf(price) + "\n";
            total += price;
        }

        result += "\nTotal price:\t" + String.valueOf(total) + "\n";

        return result;
    }

}
