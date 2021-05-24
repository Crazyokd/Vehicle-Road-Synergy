package test;

public class Answer {
    private int length=10;
    private int[] ans=initAns();

    public Answer(){}
    public Answer(int length){
        this.length=length;
    }
    public int[] initAns(){
        ans=new int[100];
        //初始化为2,2表示熄灭
        for(int i=0;i<length;i++){
            ans[i]=2;
        }
        return ans;
    }

    @Override
    public String toString(){
        String str=new String();
        for(int i=this.length-1;i>=0;i--){
            str+=String.format("%5d",ans[i]);
        }
        return str;
    }

    public int[] getAns() {
        return ans;
    }
    public int getLength() {
        return length;
    }
}
