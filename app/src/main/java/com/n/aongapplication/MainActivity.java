package com.n.aongapplication;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Gravity;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.Button;
        import android.widget.TextSwitcher;
        import android.widget.TextView;
        import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private TextSwitcher simpleTextSwitcher;
    Button btnNext;


    // Array of String to Show In TextSwitcher
    String strings[] = {"แบล็ก แพนเธอร์ หรือ ที ชัลลา (T’Challa) เป็นซูเปอร์ฮีโร่ชาวแอฟริกา ปรากฏตัวในหนังสือการ์ตูนอเมริกันที่ตีพิมพ์โดย มาร์เวลคอมิกส์ ได้รับการสร้างสรรค์โดยนักเขียน สแตน ลี และนักวาด แจ็ก เคอร์บี ปรากฏตัวครั้งแรกใน แฟนตาสติคโฟร์ เล่มที่ 52  โดยปัจจุบันฉบับหนังได้นักแสดงมากความสามารถอย่าง แชดวิก โบสแมน มารับบทเป็น แบล็ก แพนเทอร์ ", "แบล็ก แพนเธอร์ หรือชื่อจริงคือ ที ชัลลา มาจากอาณาจักร วากานดา (ประเทศสมมุติไม่มีอยู่จริง) เป็นประเทศเล็ก ๆ ทางตะวันตกของทวีปแอฟริกา เป็นประเทศสันโดษที่แยกตัวออกห่างจากสังคมภายนอกจนแม้แต่บางคนยังไม่รู้ว่ามีประเทศนี้อยู่ด้วยซ้ำ ถึงจะดูเป็นประเทศที่เหมือนล้าหลังห่างไกลความเจริญ แต่ความจริงแล้ว วากานดา ได้เก็บงำซ่อนเทคโนโลยีสุดล้ำสมัยเป็นความลับ", "ที ชัลลา เป็นบุตรชายของ ที ชากา (T’Chaka) ราชาแห่ง วากานดา อึนยามี ภรรยาคนแรกของชากาได้เสียชีวิตลงขณะให้กำเนิดชัลลา ต่อมา รามอนดา ภรรยาคนที่สองถูกจับตัวไป บิดาจึงเลี้ยงเขามาตั้งแต่เด็ก", "แฟนตัวจริงของมาร์เวลย่อมรู้จักกับแร่ ไวเบรเนียม กันดีอยู่แล้ว มันถูกใช้เป็นวัตถุดิบหลักในการผลิตโล่ของ กัปตันอเมริกา ซึ่งเป็นแร่ที่แข็งมาก และยังสามารถดูดซึมแรงกระแทกหรือพลังโจมที่ได้ทุกรูปแบบ แต่น้อยคนที่จะรู้ว่าประเทศเล็กๆ อย่าง วากานดา กลับมีแร่หายากนี้อยู่มหาศาล", "เนื่องจากในอดีตเคยมี อุกกาบาต ที่มีส่วนประกอบเป็น แร่ไวเบรเนียม ตกลงมายังดินแดนแห่งนี้ แต่ก็อย่างที่บอกไปข้างต้น ว่าประเทศนี้ได้เก็บเรื่องพวกนี้ไว้เป็นความลับเช่นกัน จนกระทั่ง ที ชัลลา ได้ตัดสินใจขายแร่ไวเบรเนียมส่วนเล็ก ๆ เพื่อแลกกับเงินจำนวนมหาศาล มาขับเคลื่อนเศรษฐกิจของวากานดา และผลักดันให้เกิดความก้าวหน้าทางเทคโนโลยีในประเทศแห่งนี้"};
    int messageCount = strings.length;
    // to keep current Index of textID array
    int currentIndex = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // get The references if Button and TextSwitcher
        btnNext = (Button) findViewById(R.id.buttonNext);
        simpleTextSwitcher = (TextSwitcher) findViewById(R.id.simpleTextSwitcher);
        // Set the ViewFactory of the TextSwitcher that will create TextView object when asked
        simpleTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub
                // create a TextView
                TextView t = new TextView(MainActivity.this);
                // set the gravity of text to top and center horizontal
                t.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                // set displayed text size
                t.setTextSize(36);
                return t;
            }
        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to TextSwitcher
        simpleTextSwitcher.setInAnimation(in);
        simpleTextSwitcher.setOutAnimation(out);

        //text appear on start
        simpleTextSwitcher.setCurrentText("ยินดีต้อนรับสู่แฟนคลับ ราชาเสือดำ");
        // ClickListener for NEXT button
        // When clicked on Button TextSwitcher will switch between labels
        // The current label will go out and next label will come in with specified animation
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                currentIndex++;
                // If index reaches maximum then reset it
                if (currentIndex == messageCount)
                    currentIndex = 0;
                simpleTextSwitcher.setText(strings[currentIndex]); // set Text in TextSwitcher
            }
        });

    }

}