/*
 * Copyright (c) 2016 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.raywenderlich.camelot;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.Manifest.permission.RECORD_AUDIO;

public class MainActivity extends AppCompatActivity {

  private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;

  private boolean mPermissionToRecordAccepted = false;
  private String[] mPermissions = {RECORD_AUDIO};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button consentButton = (Button)findViewById(R.id.consentButton);

    consentButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        displayConsent();
      }
    });

    Button surveyButton = (Button)findViewById(R.id.surveyButton);

    surveyButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        displaySurvey();
      }
    });

    Button microphoneButton = (Button)findViewById(R.id.microphoneButton);

    microphoneButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(),
            RECORD_AUDIO);
        if (result == PackageManager.PERMISSION_GRANTED) {
          displayAudioTask();
        } else {
          ActivityCompat.requestPermissions(MainActivity.this, mPermissions,
              REQUEST_RECORD_AUDIO_PERMISSION);
        }
      }
    });
  }


  private void displayConsent() {

  }

  private void displaySurvey() {

  }

  private void displayAudioTask() {

  }

}
