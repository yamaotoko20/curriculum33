package person;

import java.text.DecimalFormat;

import vehicle.Bicycle;
import vehicle.Car;

public class Person {
	public static int count = 0;
	public String firstName;
	public String lastName; // 追加されたインスタンスフィールド
	public int age;
	public double height, weight;
	
	// firstNameとlastNameを受け取るコンストラクタ
	 public Person(String firstName, String lastName, int age, double height, double weight){
        this.firstName = firstName;
        this.lastName = lastName; // lastName を設定
        this.age = age;
        this.height = height;
        this.weight = weight;
        count++;
    }
	
	// lastNameのみを受け取るコンストラクタ
	 public Person(String firstName, int age, double height, double weight, String lastName){
        this.firstName = firstName;
        this.lastName = lastName; // lastNameの値をセット
        this.age = age;
        this.height = height;
        this.weight = weight;
        count++;
    }

	
	
	public String fullName(){
        if (this.firstName != null && this.lastName != null) {
            return this.firstName + " " + this.lastName; // スペースで連結
        } else {
            return "名前未設定";
        }
    }
	
		public void print(){
	        if (this.firstName != null && this.lastName != null) {
	            System.out.println("名前は" + this.fullName() + "です");
	            System.out.println("年は" + this.age + "です");
	            DecimalFormat df = new DecimalFormat("#.#");
	            double bmi = this.bmi();
	            System.out.println("BMIは" + df.format(bmi) + "です");
	        } else {
	            System.out.println("エラー：名前が未設定です。");
	        }
	    }

    public double bmi(){
        return Math.floor(this.weight / (this.height * this.height) * 10) / 10.0; // BMIを小数点第一位まで計算
    }

	public static void printCount(){
	System.out.println("合計" + Person.count + "人です");
	}
	
	// インスタンスメソッドbuyを定義
	public void buy(Car car) {
	car.setOwner(this.fullName());
	System.out.println(car.getOwner() + "が購入しました");
	}

	public void buy(Bicycle bicycle) {
	bicycle.setOwner(this.fullName());
	System.out.println(bicycle.getOwner() + "が購入しました");
	}
	
	
	

}