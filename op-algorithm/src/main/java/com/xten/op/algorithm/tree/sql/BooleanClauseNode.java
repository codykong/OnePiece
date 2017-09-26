package com.xten.op.algorithm.tree.sql;


/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/16
 * Time: 下午2:03
 */
public class BooleanClauseNode {

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public enum FilterLogicalExpression {

        AND{
            @Override
            public boolean calcWithIgnoreRight(boolean a) {
                return true && a;
            }
        },
        OR{
            @Override
            public boolean calcWithIgnoreRight(boolean a) {
                return false || a;
            }
        };

        public abstract boolean calcWithIgnoreRight(boolean a);
    }

    private BooleanClauseNode left;
    private BooleanClauseNode right;
    //如果是表达式节点,则不可为空
    private FilterLogicalExpression occur;
    // 因子对应的索引,用于获取因子在数组中的结果; 如果是因子节点,则不可为空
    private Integer index;

    // 表达式节点对应的结果
    private Boolean data;

    private int level;
    public BooleanClauseNode(FilterLogicalExpression expression,int level){
        this.occur = expression;
        this.level = level;
    }
    public BooleanClauseNode(int index){
        this.index = index;
    }


    /**
     * 在不能忽略右子树的前提下计算
     * @param rightData
     */
    public void setDataWithNotIgnoreRight(boolean rightData){
        data = occur.calcWithIgnoreRight(rightData);
    }

    /**
     * 判断是否忽略右子树,直接进行判断
     * @param leftData
     * @return
     */
    public boolean ignoreRight(boolean leftData){
        if ((occur.equals(FilterLogicalExpression.AND) && leftData == false)
                || (occur.equals(FilterLogicalExpression.OR) && leftData == true)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 判断是否有子树
     * @return
     */
    public boolean hasChild(){
        // 如果有左子树则认为有孩子节点
        return left != null;
    }

    public BooleanClauseNode(){}

    public BooleanClauseNode(FilterLogicalExpression expression){
        this.occur = expression;
    }

    public BooleanClauseNode(Integer index){
        this.index = index;
    }


    public BooleanClauseNode getLeft() {
        return left;
    }

    public void setLeft(BooleanClauseNode left) {
        this.left = left;
    }

    public BooleanClauseNode getRight() {
        return right;
    }

    public void setRight(BooleanClauseNode right) {
        this.right = right;
    }

    public FilterLogicalExpression getOccur() {
        return occur;
    }

    public void setOccur(FilterLogicalExpression occur) {
        this.occur = occur;
    }
    public void setOccur(String type) {
        if(type.equals("AND"))
            this.occur = FilterLogicalExpression.AND;
        else if(type.equals("OR"))
            this.occur = FilterLogicalExpression.OR;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Boolean getData() {
        return data;
    }

    public void setData(Boolean data) {
        this.data = data;
    }
}
