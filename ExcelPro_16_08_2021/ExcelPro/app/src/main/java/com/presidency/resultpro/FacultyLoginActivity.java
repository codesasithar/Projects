package com.presidency.resultpro;



import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import com.google.android.gms.common.api.ApiException;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import spencerstudios.com.bungeelib.Bungee;


public class FacultyLoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button  btnLogin, btnReset;
    public TextView rstpwd;
    final String TAG = "LoginActivity";
    final int RC_SIGN_IN = 100;
    public static GoogleSignInClient mgoogleSignInClient;
    // SignInButton sign_in_button;
    public static Uri personPhoto;
    public static GoogleSignInAccount account;

    static String personName,personEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);





        // sign_in_button =findViewById(R.id.SignButton);
        //configureGoogleClient();
        //  firebaseAuthWithGoogle(GoogleSignInAccount account);

        // auth = FirebaseAuth.getInstance();

        // if (auth.getCurrentUser() != null) {
        //  startActivity(new Intent(FacultyLoginActivity.this, FacultyDashboard.class));
        //    Bungee.zoom(this);
        //     finish();
        //}



        //  sign_in_button.setOnClickListener(new View.OnClickListener() {
        // @Override
        //  public void onClick(View v) {
        //doGoogleSignIn();


        //  }
        //   });

        // set the view now
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        inputEmail = findViewById(R.id.editText25);
        rstpwd = findViewById(R.id.button26);
        inputPassword = findViewById(R.id.editText27);
        progressBar = findViewById(R.id.progress_bar);

        btnLogin = findViewById(R.id.button25);
        btnReset = findViewById(R.id.btn_reset_password);
        ImageView img = findViewById(R.id.img);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.actions);
        img.startAnimation(animation);
        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        btnLogin.startAnimation(myAnim);
        // btnSignup.animate().alpha(1f).translationYBy(-50).setDuration(1500);
        // sign_in_button.animate().alpha(1f).translationYBy(-50).setDuration(1500);
        inputEmail.animate().alpha(1f).translationYBy(-50).setDuration(1500);
        inputPassword.animate().alpha(1f).translationYBy(-50).setDuration(1500);
        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();


rstpwd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(FacultyLoginActivity.this,ResetPasswordActivity.class);
        startActivity(intent);
    }
});


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(FacultyLoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override

                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(FacultyLoginActivity.this, "Please check credentials", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(FacultyLoginActivity.this, FacultyDashboard.class);
                                    startActivity(intent);

                                    finish();
                                }
                            }
                        });
            }
        });
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(FacultyLoginActivity.this, welcome.class);
        startActivity(intent);
        Bungee.zoom(this);
    }


    private void configureGoogleClient() {
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                // for the requestIdToken, this is in the values.xml file that
                // is generated from your google-services.json
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // Build a GoogleSignInClient with the options specified by gso.
        mgoogleSignInClient = GoogleSignIn.getClient(this, gso);
        // Set the dimensions of the sign-in button.

        //signInButton.setSize(SignInButton.SIZE_WIDE);
        // Initialize Firebase Auth
        // firebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            Log.d(TAG, "Currently Signed in: " + currentUser.getEmail());
            // showToastMessage("Currently Logged in: " + currentUser.getEmail());
            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
            //updateUI(account);
        }
    }


    private void signIn() {
        Intent signInIntent = mgoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = auth.getCurrentUser();
                            Log.d(TAG, "signInWithCredential:success: currentUser: " + user.getEmail());
                            showToastMessage("Firebase Authentication Succeeded ");
                            launchMainActivity(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            showToastMessage("Firebase Authentication failed:" + task.getException());
                        }
                    }
                });
    }

    private void showToastMessage(String message) {
        Toast.makeText(FacultyLoginActivity.this, message, Toast.LENGTH_LONG).show();
    }

    private void launchMainActivity(FirebaseUser user) {
        if (user != null) {
            //  ProfileActivity.startActivity(this, user.getDisplayName());
            finish();
        }
    }

    private void updateUI(@Nullable GoogleSignInAccount account) {
        if (account != null) {
            // mStatusTextView.setText(getString(R.string.signed_in_fmt, account.getDisplayName()));


            // findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);
        } else {
            //mStatusTextView.setText(R.string.signed_out);


            // findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
        }
    }




    /**
     * custom sign in button click event
     *
     * @param view custom button
     */
    public void customGoogleSignIn(View view) {
        doSignInSignOut();
    }

    /**
     * method to do Sign In or Sign Out on the basis of account exist or not
     */
    private void doSignInSignOut() {

        //get the last sign in account
        account = GoogleSignIn.getLastSignedInAccount(this);

        //if account doesn't exist do login else do sign out
        if (account == null)
            doGoogleSignIn();
        else
            doGoogleSignOut();
    }

    /**
     * do google sign in
     */
    public void doGoogleSignIn() {
        //account = GoogleSignIn.getLastSignedInAccount(this);
        Intent signInIntent = mgoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);

        //pass the declared request code here
        // if (account != null) {
        ///   Intent intent = new Intent(LoginActivity.this, MainActivityfirst.class);
        //  startActivity(intent);
    }
    // else{
    //

    //  }

    // }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            //method to handle google sign in result
            handleSignInResult(task);
        }
    }

    /**
     * method to handle google sign in result
     *
     * @param completedTask from google onActivityResult
     */
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            getProfileInformation(account);

            //show toast
            Toast.makeText(this, "Google Sign In Successful.", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(FacultyLoginActivity.this, menudrawer.class);
            startActivity(intent);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.e(TAG, "signInResult:failed code=" + e.getStatusCode());

            //show toast
            Toast.makeText(this, "Failed to do Sign In : " + e.getStatusCode(), Toast.LENGTH_SHORT).show();

            //update Ui for this
            getProfileInformation(null);
        }
    }

    /**
     * method to fetch user profile information from GoogleSignInAccount
     *
     * @param acct googleSignInAccount
     */
    private void getProfileInformation(GoogleSignInAccount acct) {
        //if account is not null fetch the information
        if (acct != null) {

            //user display name
            personName = acct.getDisplayName();

            //user first name
            String personGivenName = acct.getGivenName();

            //user last name
            String personFamilyName = acct.getFamilyName();

            //user email id
            personEmail = acct.getEmail();

            //user unique id
            String personId = acct.getId();

            //user profile pic
            personPhoto = acct.getPhotoUrl();

            //show the user details
            //  userDetailLabel.setText("ID : " + personId + "\nDisplay Name : " + personName + "\nFull Name : " + personGivenName + " " + personFamilyName + "\nEmail : " + personEmail);

            //show the user profile pic
//            Picasso.with(this).load(personPhoto).fit().placeholder(R.mipmap.ic_launcher_round).into(userProfileImageView);

            //change the text of Custom Sign in button to sign out
            //   customSignInButton.setText(getResources().getString(R.string.sign_out));

            //show the label and image view
            //  userDetailLabel.setVisibility(View.VISIBLE);
            //  userProfileImageView.setVisibility(View.VISIBLE);

        } else {

            //if account is null change the text back to Sign In and hide the label and image view
            //  customSignInButton.setText(getResources().getString(R.string.sign_in));
            // userDetailLabel.setVisibility(View.GONE);
            //  userProfileImageView.setVisibility(View.GONE);

        }
    }

    /**
     * method to do google sign out
     * This code clears which account is connected to the app. To sign in again, the user must choose their account again.
     */
    private void doGoogleSignOut() {
        mgoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(FacultyLoginActivity.this, "Google Sign Out done.", Toast.LENGTH_SHORT).show();
                        revokeAccess();
                    }
                });
    }

    /**
     * DISCONNECT ACCOUNTS
     * method to revoke access from this app
     * call this method after successful sign out
     * <p>
     * It is highly recommended that you provide users that signed in with Google the ability to disconnect their Google account from your app. If the user deletes their account, you must delete the information that your app obtained from the Google APIs
     */
    private void revokeAccess() {
        mgoogleSignInClient.revokeAccess()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(FacultyLoginActivity.this, "Google access revoked.", Toast.LENGTH_SHORT).show();
                        getProfileInformation(null);
                    }
                });
    }
}