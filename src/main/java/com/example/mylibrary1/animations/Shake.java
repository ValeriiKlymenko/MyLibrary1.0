package com.example.mylibrary1.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

//анімація кнопка трясеться, якщо не правильний логін пароль
public class Shake {
    private TranslateTransition tt;
    // import Node
    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(70), node);
        // відступ від х = 0
        tt.setFromX(0f);
        //на скільки він передвинеться від теперішньої позиції
        tt.setByX(10f);
        //скільки раз програє анімація
        tt.setCycleCount(3);
        //щоб повертався назад
        tt.setAutoReverse(true );
    }
    //викликаємо в LoginRegistView це перевірка чи є користувач у БД
    public void playAnim(){
        //запускає анімацію
        tt.playFromStart();
    }
}
