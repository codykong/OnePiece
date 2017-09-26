package com.xten.op.tree.sql;

/**
 * Created with IntelliJ IDEA.
 * User: kongqingyu
 * Date: 2016/12/20
 * Time: 下午12:57
 */
public enum FilterLogicalExpression {

    AND{
        @Override
        public boolean calc(boolean a, boolean b) {
            return a && b;
        }
    },
    OR{
        @Override
        public boolean calc(boolean a, boolean b) {
            return a || b;
        }
    };

    public abstract boolean calc(boolean a,boolean b);
}
