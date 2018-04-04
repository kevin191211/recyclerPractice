package com.example.ystar.recyclerview;

/**
 * Created by Deliver-PC003 on 2017/11/9.
 */

public class BindingUtils {
    //
    //@BindingAdapter({"app:image_url", "app:place_holder", "app:error_holder"})
    //public static void imageLoaderWithAnimationHolder(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
    //    playDrawableAnimation(holderDrawable);
    //    if (TextUtils.isEmpty(url)) {
    //        Glide.with(imageView.getContext())
    //                .load(holderDrawable)
    //                .apply(RequestOptions.centerInsideTransform())
    //                .into(imageView);
    //        return;
    //    }
    //
    //    RequestOptions requestOptions = RequestOptions.centerInsideTransform();
    //    if (holderDrawable != null) {
    //        requestOptions = requestOptions.placeholder(holderDrawable);
    //    }
    //
    //    if (errorDrawable != null) {
    //        playDrawableAnimation(errorDrawable);
    //        requestOptions = requestOptions.error(errorDrawable);
    //    }
    //
    //    Glide.with(imageView.getContext())
    //            .load(url)
    //            .apply(requestOptions)
    //            .into(imageView);
    //}
    //
    //@BindingAdapter({"app:image_url", "app:place_holder"})
    //public static void imageLoaderWithAnimationHolder(ImageView imageView, String url, Drawable holderDrawable) {
    //    playDrawableAnimation(holderDrawable);
    //    if (TextUtils.isEmpty(url)) {
    //        Glide.with(imageView.getContext())
    //                .load(holderDrawable)
    //                .apply(RequestOptions.centerInsideTransform())
    //                .into(imageView);
    //        return;
    //    }
    //
    //    RequestOptions requestOptions = RequestOptions.centerInsideTransform();
    //    if (holderDrawable != null) {
    //        requestOptions = requestOptions.placeholder(holderDrawable);
    //    }
    //
    //    Glide.with(imageView.getContext())
    //            .load(url)
    //            .apply(requestOptions)
    //            .into(imageView);
    //}
    //
    //private static void playDrawableAnimation(Drawable drawable) {
    //    if (drawable != null && drawable instanceof AnimationDrawable) {
    //        AnimationDrawable animationPlaceholder = (AnimationDrawable) drawable;
    //        animationPlaceholder.start();
    //    }
    //}
    //
    //@BindingAdapter({"app:image_url"})
    //public static void imageLoader(ImageView imageView, String url) {
    //    if (TextUtils.isEmpty(url)) {
    //        imageView.setImageResource(0);
    //        return;
    //    }
    //
    //    Glide.with(imageView.getContext())
    //            .load(url)
    //            .apply(RequestOptions.centerInsideTransform())
    //            .into(imageView);
    //}
    //
    //@BindingAdapter({"app:image_identifier"})
    //public static void imageIdentifier(ImageView imageView, String identifier) {
    //    if (TextUtils.isEmpty(identifier)) {
    //        return;
    //    }
    //
    //    Context context = imageView.getContext();
    //    int imageId = context.getResources().getIdentifier(identifier, "drawable", context.getPackageName());
    //    if (imageId != 0) {
    //        imageView.setImageResource(imageId);
    //    }
    //}
    //
    //@BindingAdapter({"app:web_url"})
    //public static void webViewLoader(WebView webView, String url) {
    //    if (TextUtils.isEmpty(url)) {
    //        return;
    //    }
    //
    //    webView.loadUrl(url);
    //}
    //
    //@BindingAdapter("android:src")
    //public static void setImageUri(ImageView view, String imageUri) {
    //    if (imageUri == null) {
    //        view.setImageURI(null);
    //    } else {
    //        view.setImageURI(Uri.parse(imageUri));
    //    }
    //}
    //
    //@BindingAdapter("android:src")
    //public static void setImageUri(ImageView view, Uri imageUri) {
    //    view.setImageURI(imageUri);
    //}
    //
    //@BindingAdapter("android:src")
    //public static void setImageDrawable(ImageView view, Drawable drawable) {
    //    view.setImageDrawable(drawable);
    //}
    //
    //@BindingAdapter("android:src")
    //public static void setImageResource(ImageView imageView, int resource) {
    //    imageView.setImageResource(resource);
    //}
}
