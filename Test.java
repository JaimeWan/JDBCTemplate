package JDBCTemplate;

import JDBCTemplate.Crud;

public class Test {
    public static void main(String[] args) {
        Crud q=new Crud();
        q.selectByID(1,11);
        q.selectByName("'胡%'");
        q.Insert();
        q.Update("Jack",28);
        q.DeleteByName("Gates'");
    }
}
