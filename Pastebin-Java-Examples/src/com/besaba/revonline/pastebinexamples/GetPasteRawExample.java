import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.factory.PastebinFactory;
import com.besaba.revonline.pastebinapi.response.Response;

public class GetPasteRawExample {
  public static final String DEV_KEY = "Q8EhcnQl9WGCZYdpq5rgqTby_kboAZAr";

  public static void main(String[] args) {
    PastebinFactory factory = new PastebinFactory();
    Pastebin pastebin = factory.createPastebin(DEV_KEY);

    String pasteToRead = "EZQjAFP4";
    if (args.length > 1) {
	pasteToRead = args[1];
    }
    final Response<String> rawResponse = pastebin.getRawPaste(pasteToRead);

    if (rawResponse.hasError()) {
      System.out.println("Impossibile leggere il contenuto del paste! " + rawResponse.getError());
      return;
    }

    System.out.println(":" + rawResponse.get() + ":");
  }
}
