package com.example.inthepocket;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomView extends View {

//public work(ArrayList<String>)

    public int roundCounter = 1;
    private static final String FILE_NAME = "test.txt";
    private Paint paint;
    ArrayList<Rect> wectangles = new ArrayList<>();
    public ArrayList booleanbros = new ArrayList<>();
    public boolean firstdraw = true;
    public int trueCounter = 0;
    public ArrayList pickedplayers = new ArrayList<>();
    public ArrayList pickedplayers2 = new ArrayList<>();
    public ArrayList pickedplayers3 = new ArrayList<>();
    public ArrayList newTest = new ArrayList(  );




    public ArrayList playersList = new ArrayList<>( );


    public CustomView(Context context) throws java.io.IOException{
        super( context );
        File file = new File( FILE_NAME );

        BufferedReader br = null;
        try {
            br = new BufferedReader( new FileReader("/data/data/com.example.inthepocket/files/test.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        while ((st = br.readLine())!=null) {
            playersList.add(st);

        }System.out.println( newTest);


    }

    @Override
    public void onDraw(Canvas canvas) {
        switch(roundCounter) {
            case 1:
                System.out.println("In case 1 >>>>>>>>>>>>>>> draw");
                canvas.drawColor(Color.argb(255, 73, 147, 30));
                Paint paint = new Paint();
                paint.setColor(Color.BLACK);
                paint.setStyle(Paint.Style.FILL);
                paint.setTextSize(80);
                //if we have time, make an odd route lol

                int toprect = 450;
                int srconstant = 550;

                int a = 250;
                int a2 = 350;
                int a3 = 1200;
                int a4 = 500;

                Paint paintRect = new Paint();
                paintRect.setColor(Color.rgb(255, 255, 255));
                Paint paintWinner = new Paint();
                paintWinner.setColor(Color.rgb(140, 255, 0));
                Paint paintLoser = new Paint();
                paintLoser.setColor(Color.rgb(192, 192, 192));


                while (wectangles.size() < playersList.size()) {
                    //this is the first forloop for the rectabgle
                    wectangles.add(new Rect(a, a2, a3, a4));
                    wectangles.add(new Rect(a, a2 + 200, a3, a4 + 200));
                    booleanbros.add(false);
                    booleanbros.add(false);


                    a2 = a2 + 500;
                    a4 = a4 + 500;
                    toprect = toprect + 500;

                }
                if (firstdraw) {
                    //these put the bad boys into the array lol
                    //top one is confirm
                    wectangles.add(new Rect(750, 2300, 1200, 2500));
                    //bottom one is clear
                    wectangles.add(new Rect(250, 2300, 700, 2500));
                    booleanbros.add(false);
                    booleanbros.add(false);
                }
                firstdraw = false;
                canvas.drawRect(wectangles.get(wectangles.size() - 1), paintRect);
                //drawing the clear button imo

                for (int i = 0; i < playersList.size(); i++) {
                    if ((boolean) booleanbros.get(i)) {
                        trueCounter++;
                        //this counts the amount of trues
                    }
                    if ((boolean) booleanbros.get(i)) {

                        if (i % 2 == 0) {
                            booleanbros.set(i, true);
                            booleanbros.set(i + 1, false);
                            canvas.drawRect((wectangles.get(i)), paintWinner);
                            canvas.drawRect((wectangles.get(i + 1)), paintLoser);

                        } else {
                            booleanbros.set(i, true);
                            booleanbros.set(i - 1, false);
                            canvas.drawRect((wectangles.get(i)), paintWinner);
                            canvas.drawRect((wectangles.get(i - 1)), paintLoser);
                            //trueCounter++;
                        }
                    } else if (!(boolean) booleanbros.get(i)) {
                        if (i % 2 == 0) {//haven't finished this
                            if ((boolean) booleanbros.get(i + 1)) {
                                canvas.drawRect((wectangles.get(i)), paintLoser);
                            } else {
                                canvas.drawRect((wectangles.get(i)), paintRect);
                            }
                        } else {
                            if ((boolean) booleanbros.get(i - 1)) {
                                canvas.drawRect((wectangles.get(i)), paintLoser);
                            } else {
                                canvas.drawRect((wectangles.get(i)), paintRect);
                            }
                        }
                    }
                }


                toprect = 450;

                for (int i = 0; i < playersList.size(); i = i + 2) {
                    //this is the second forLoop lol for the words
                    canvas.drawText((String) (playersList.get(i)), srconstant, toprect, paint);
                    canvas.drawText((String) (playersList.get(i + 1)), srconstant, (toprect + 200), paint);

                    toprect = toprect + 500;
                }


                canvas.drawText("Click winner of game", 10, 220, paint);
                canvas.drawText("Round" + roundCounter, 10, 120, paint);
                switch (playersList.size()) {
                    case 8:
                        canvas.drawText("Game 4", 10, 1800, paint);
                    case 6:
                        canvas.drawText("Game 3", 10, 1300, paint);
                    case 4:
                        canvas.drawText("Game 2", 10, 800, paint);
                    case 2:
                        canvas.drawText("Game 1", 10, 300, paint);

                }
                //confirm button only drawn if 4 selected
                if (trueCounter >= playersList.size() / 2) {
                    canvas.drawRect(wectangles.get(wectangles.size() - 2), paintRect);
                    canvas.drawText("Confirm->", 805, 2425, paint);

                }

                canvas.drawText("Clear", 390, 2425, paint);
                System.out.println("roundCounter case draw first >>>>>>>>>>>>>"+roundCounter);
                break;

            case 2:
                System.out.println("In case 2 >>>>>>>>>>>>>>> draw");
                canvas.drawColor(Color.argb(255, 73, 147, 30));
                paint = new Paint();
                paint.setColor(Color.BLACK);
                paint.setStyle(Paint.Style.FILL);
                paint.setTextSize(80);
                //if we have time, make an odd route lol

                toprect = 450;
                srconstant = 550;

                a = 250;
                a2 = 350;
                a3 = 1200;
                a4 = 500;

                paintRect = new Paint();
                paintRect.setColor(Color.rgb(255, 255, 255));
                paintWinner = new Paint();
                paintWinner.setColor(Color.rgb(140, 255, 0));
                paintLoser = new Paint();
                paintLoser.setColor(Color.rgb(192, 192, 192));


                while (wectangles.size() < pickedplayers.size()) {
                    //this is the first forloop for the rectabgle
                    wectangles.add(new Rect(a, a2, a3, a4));
                    wectangles.add(new Rect(a, a2 + 200, a3, a4 + 200));
                    booleanbros.add(false);
                    booleanbros.add(false);


                    a2 = a2 + 500;
                    a4 = a4 + 500;
                    toprect = toprect + 500;

                }
                if (firstdraw) {
                    //these put the bad boys into the array lol
                    //top one is confirm
                    wectangles.add(new Rect(750, 2300, 1200, 2500));
                    //bottom one is clear
                    wectangles.add(new Rect(250, 2300, 700, 2500));
                    booleanbros.add(false);
                    booleanbros.add(false);
                }
                firstdraw = false;
                canvas.drawRect(wectangles.get(wectangles.size() - 1), paintRect);
                //drawing the clear button imo

                for (int i = 0; i < pickedplayers.size(); i++) {
                    if ((boolean) booleanbros.get(i)) {
                        trueCounter++;
                        //this counts the amount of trues
                    }
                    if ((boolean) booleanbros.get(i)) {

                        if (i % 2 == 0) {
                            booleanbros.set(i, true);
                            booleanbros.set(i + 1, false);
                            canvas.drawRect((wectangles.get(i)), paintWinner);
                            canvas.drawRect((wectangles.get(i + 1)), paintLoser);

                        } else {
                            booleanbros.set(i, true);
                            booleanbros.set(i - 1, false);
                            canvas.drawRect((wectangles.get(i)), paintWinner);
                            canvas.drawRect((wectangles.get(i - 1)), paintLoser);
                            //trueCounter++;
                        }
                    } else if (!(boolean) booleanbros.get(i)) {
                        if (i % 2 == 0) {//haven't finished this
                            if ((boolean) booleanbros.get(i + 1)) {
                                canvas.drawRect((wectangles.get(i)), paintLoser);
                            } else {
                                canvas.drawRect((wectangles.get(i)), paintRect);
                            }
                        } else {
                            if ((boolean) booleanbros.get(i - 1)) {
                                canvas.drawRect((wectangles.get(i)), paintLoser);
                            } else {
                                canvas.drawRect((wectangles.get(i)), paintRect);
                            }
                        }
                    }

                }


                toprect = 450;

                for (int i = 0; i < pickedplayers.size(); i = i + 2) {
                    //this is the second forLoop lol for the words
                    canvas.drawText((String) (pickedplayers.get(i)), srconstant, toprect, paint);
                    canvas.drawText((String) (pickedplayers.get(i + 1)), srconstant, (toprect + 200), paint);

                    toprect = toprect + 500;
                }


                canvas.drawText("Click winner of game", 10, 220, paint);
                canvas.drawText("Round" + roundCounter, 10, 120, paint);
                System.out.println(pickedplayers.size());
                switch (pickedplayers.size()) {
                    case 8:
                        canvas.drawText("Game 4", 10, 1800, paint);
                    case 6:
                        canvas.drawText("Game 3", 10, 1300, paint);
                    case 4:
                        canvas.drawText("Game 2", 10, 800, paint);
                    case 2:
                        canvas.drawText("Game 1", 10, 300, paint);

                }
                //confirm button only drawn if 4 selected
                if (trueCounter >= pickedplayers.size() / 2) {
                    canvas.drawRect(wectangles.get(wectangles.size() - 2), paintRect);
                    canvas.drawText("Confirm->", 805, 2425, paint);

                }


                canvas.drawText("Clear", 390, 2425, paint);
                System.out.println("roundCounter case draw second >>>>>>>>>>>>>"+roundCounter);
                break;
            case 3:
                System.out.println("In case 3 >>>>>>>>>>>>>>> draw");
                canvas.drawColor(Color.argb(255, 73, 147, 30));
                paint = new Paint();
                paint.setColor(Color.BLACK);
                paint.setStyle(Paint.Style.FILL);
                paint.setTextSize(80);
                //if we have time, make an odd route lol

                toprect = 450;
                srconstant = 550;

                a = 250;
                a2 = 350;
                a3 = 1200;
                a4 = 500;

                paintRect = new Paint();
                paintRect.setColor(Color.rgb(255, 255, 255));
                paintWinner = new Paint();
                paintWinner.setColor(Color.rgb(140, 255, 0));
                paintLoser = new Paint();
                paintLoser.setColor(Color.rgb(192, 192, 192));


                while (wectangles.size() < pickedplayers2.size()) {
                    //this is the first forloop for the rectabgle
                    wectangles.add(new Rect(a, a2, a3, a4));
                    wectangles.add(new Rect(a, a2 + 200, a3, a4 + 200));
                    booleanbros.add(false);
                    booleanbros.add(false);


                    a2 = a2 + 500;
                    a4 = a4 + 500;
                    toprect = toprect + 500;

                }
                if (firstdraw) {
                    //these put the bad boys into the array lol
                    //top one is confirm
                    wectangles.add(new Rect(750, 2300, 1200, 2500));
                    //bottom one is clear
                    wectangles.add(new Rect(250, 2300, 700, 2500));
                    booleanbros.add(false);
                    booleanbros.add(false);
                }
                firstdraw = false;
                canvas.drawRect(wectangles.get(wectangles.size() - 1), paintRect);
                //drawing the clear button imo

                for (int i = 0; i < pickedplayers2.size(); i++) {
                    if ((boolean) booleanbros.get(i)) {
                        trueCounter++;
                        //this counts the amount of trues
                    }
                    if ((boolean) booleanbros.get(i)) {

                        if (i % 2 == 0) {
                            booleanbros.set(i, true);
                            booleanbros.set(i + 1, false);
                            canvas.drawRect((wectangles.get(i)), paintWinner);
                            canvas.drawRect((wectangles.get(i + 1)), paintLoser);

                        } else {
                            booleanbros.set(i, true);
                            booleanbros.set(i - 1, false);
                            canvas.drawRect((wectangles.get(i)), paintWinner);
                            canvas.drawRect((wectangles.get(i - 1)), paintLoser);
                            //trueCounter++;
                        }
                    } else if (!(boolean) booleanbros.get(i)) {
                        if (i % 2 == 0) {//haven't finished this
                            if ((boolean) booleanbros.get(i + 1)) {
                                canvas.drawRect((wectangles.get(i)), paintLoser);
                            } else {
                                canvas.drawRect((wectangles.get(i)), paintRect);
                            }
                        } else {
                            if ((boolean) booleanbros.get(i - 1)) {
                                canvas.drawRect((wectangles.get(i)), paintLoser);
                            } else {
                                canvas.drawRect((wectangles.get(i)), paintRect);
                            }
                        }
                    }

                }


                toprect = 450;

                for (int i = 0; i < pickedplayers2.size(); i = i + 2) {
                    //this is the second forLoop lol for the words
                    canvas.drawText((String) (pickedplayers2.get(i)), srconstant, toprect, paint);
                    canvas.drawText((String) (pickedplayers2.get(i + 1)), srconstant, (toprect + 200), paint);

                    toprect = toprect + 500;
                }


                canvas.drawText("Click winner of game", 10, 220, paint);
                canvas.drawText("Round" + roundCounter, 10, 120, paint);
                System.out.println(pickedplayers2.size());
                switch (pickedplayers2.size()) {
                    case 8:
                        canvas.drawText("Game 4", 10, 1800, paint);
                    case 6:
                        canvas.drawText("Game 3", 10, 1300, paint);
                    case 4:
                        canvas.drawText("Game 2", 10, 800, paint);
                    case 2:
                        canvas.drawText("Game 1", 10, 300, paint);

                }
                //confirm button only drawn if 4 selected
                if (trueCounter >= pickedplayers2.size() / 2) {
                    canvas.drawRect(wectangles.get(wectangles.size() - 2), paintRect);
                    canvas.drawText("Confirm->", 805, 2425, paint);

                }

                canvas.drawText("Clear", 390, 2425, paint);
                System.out.println("roundCounter case draw third >>>>>>>>>>>>>"+roundCounter);

        }//switch end
    }//ondraw end

    public boolean onTouchEvent(MotionEvent event) {
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();

        boolean touch =true;
        if (MotionEvent.ACTION_DOWN == 0) {
            for (int i = 0; i < booleanbros.size(); i++) {
                if (wectangles.get(i).contains(touchX, touchY)) {
                    booleanbros.set(i, true);
                    invalidate();
                    if (i == (wectangles.size() - 1)) {
                        for (int k = 0; k < booleanbros.size(); k++) {
                            booleanbros.set(k, false);
                            trueCounter = 0;
                        }
                    }
                    System.out.println(trueCounter);
                    if (i == (wectangles.size() - 2)) {
                        switch(roundCounter){
                            case 1:
                                for (int p = 0; p < playersList.size(); p++) {
                                    if ((boolean) booleanbros.get(p)) {
                                        if (pickedplayers.size() < (playersList.size() / 2)) {
                                            pickedplayers.add(playersList.get(p));
                                        }
                                    }
                                }
                                firstdraw = true;
                                wectangles.clear();
                                trueCounter=0;
                                booleanbros.clear();
                                roundCounter++;
                                System.out.println("roundCounter case 1 >>>>>>>>>>>>>"+roundCounter);
                                touch = false;
                                break;
                            case 2:
                                if(wectangles.get(i).contains(touchX, touchY) ){
                                    for (int p = 0; p < pickedplayers.size(); p++) {
                                        if ((boolean) booleanbros.get(p)) {
                                            if (pickedplayers2.size() < (pickedplayers.size() / 2)) {
                                                pickedplayers2.add(pickedplayers.get(p));
                                            }
                                        }
                                    }
                                    System.out.println("Round 2 end>>>>>>>>>"+pickedplayers2);
                                    firstdraw = true;
                                    wectangles.clear();
                                    booleanbros.clear();
                                    roundCounter++;
                                    System.out.println("roundCounter case 2 >>>>>>>>>>>>>"+roundCounter);
                                    touch = false;
                                    break;
                                }
                            case 3:
                                if(wectangles.get(i).contains(touchX, touchY) ){
                                    System.out.println("Round 2 start of round 3>>>>>>>>>"+pickedplayers2);
                                    for (int p = 0; p < pickedplayers2.size(); p++) {
                                        if ((boolean) booleanbros.get(p)) {
                                            if (pickedplayers3.size() < (pickedplayers2.size() / 2)) {
                                                pickedplayers3.add(pickedplayers2.get(p));
                                            }
                                        }
                                    }
                                    System.out.println("Round 3 end");
                                    firstdraw = true;
                                    wectangles.clear();
                                    booleanbros.clear();
                                    System.out.println("roundCounter case 3 >>>>>>>>>>>>>"+roundCounter);
                                    touch = false;
                                    //roundCounter++;
                                }
                        }


                    }
                }
            }
        }
        if (MotionEvent.ACTION_DOWN == 0) {
            //System.out.println( touchX + " " + touchY );
            //wectangles.contains( touchX, touchY ))

            for (int i = 0; i < booleanbros.size(); i++) {
                //System.out.println( wectangles.get( i ) );
                if (wectangles.get(i).contains(touchX, touchY)) {
                    booleanbros.set(i, true);
                    trueCounter = 0;
                    invalidate();
                }
            }
        }
        return touch;
    }

}

