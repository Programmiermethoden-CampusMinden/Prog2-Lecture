public class JavalinExample {
    public static void main(String[] args) {
        //runs on localhost:8080
        Javalin app = Javalin.create().start(8080);
        app.before(ctx -> {
            System.out.println("Request eingegangen");
        });

        app.get("/", ctx -> ctx.result(randomInt()));

        app.after(ctx -> {
            System.out.println("Request abgearbeitet");
        });
    }

    public static String randomInt(){
        Random r = new Random();
        return ""+r.nextInt();
    }
}