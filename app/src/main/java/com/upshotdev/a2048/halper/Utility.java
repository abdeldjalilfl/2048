package com.upshotdev.a2048.halper;

import android.app.SearchManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Utility {

    /**
     *
     * @param context context
     * @param username username account or page instagram ex: upshot.dv
     */
    public static void instagramPage(@NonNull Context context, @NonNull String username) {
        Intent intent;
        try {
            context.getPackageManager().getPackageInfo("com.instagram.android", 0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/"+ username));
        } catch (Exception e) {
            intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, "http://www.instagram.com/"+ username);
        }
        context.startActivity(intent);
    }

    /**
     *
     * @param context context
     * @param to send this email to ex : upshotdev@gmail.com
     */
    public static void sendEmail(@NonNull Context context, @NonNull String to) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        //intent.setDataAndType(Uri.parse("mailto:"),"message/rfc822");
        intent.setData(Uri.parse("mailto:?to="+to));
        intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
        try {
            context.startActivity(Intent.createChooser(intent,"Send mail "));
        } catch (Exception e) {
            Toast.makeText(context, "There are no email clients app installed", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     *
     * @param context context
     * @param text share text to social media or apps support textPlain
     */
    public static void shareText(@NonNull Context context, @NonNull String text) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, UpshotLink.playStore);
        context.startActivity(Intent.createChooser(sharingIntent, "Share "));
    }

    /**
     *
     * @param context context
     * @param text make text as primary in Clipboard
     */
    public static void copyToClipboard(Context context,@NonNull String text) {
        ClipboardManager clipboardManager=(ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData=ClipData.newPlainText("label",text);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(context, "Text copied", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     *
     * @return current date , format dd/MM/yyyy
     */
    public static String currentDate(){
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return dateFormat.format(Calendar.getInstance().getTime());
    }

    /**
     *
     * @param d amount
     * @return string amount #,##0.00 ex d=1230.99 return 1 230,99
     */
    public static String formatSymbolsCurrency(Double d){

        DecimalFormatSymbols formatSymbols =new DecimalFormatSymbols(Locale.ENGLISH);
        formatSymbols.setDecimalSeparator(',');
        formatSymbols.setGroupingSeparator(' ');
        NumberFormat format = new DecimalFormat("#,##0.00",formatSymbols);

        return format.format(d);
    }
}
