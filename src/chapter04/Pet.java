package chapter04;

    public class Pet {
        //属性【宠物名称】
        String nickname;
        //属性【健康值】
        Integer health;
        //属性【经验值】
        Integer exp;
        //属性【等级】
        Integer level;

        //空参空主体构造函数
        //不指定任何成员变量的初始化（用它构造的对象的成员默认是null）
        public Pet() {
        }

        //带参构造函数
        public Pet(String nickname) {
            this.nickname = nickname;
        }
        //【全参】构造函数（可以初始化所有成员变量）
        public Pet(String nickname,Integer exp, Integer health, Integer level, String bread) {
            this.nickname = nickname;
            this.exp = exp;
            this.health = health;
            this.level = level;
        }

        //成员方法
        public void show(){
            System.out.println("【=====宠物"+getType()+"的信息====】");
            System.out.println("【昵称】" + this.nickname);
            System.out.println("【经验值】" + this.exp);
            System.out.println("【健康值】" + this.health);
            System.out.println("【等级】" + this.level);
        }
        public String getType(){
        return "";
        }

    }

