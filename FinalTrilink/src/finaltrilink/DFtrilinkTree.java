/*
******************************************************
*** Trilink Tree
*** Daniel Flores
******************************************************
*** Created as part of the Final Exam
******************************************************
*** December 8, 2017
******************************************************
*** Original, no changes
******************************************************
 */
package finaltrilink;



public class DFtrilinkTree 
{
    private DFtrilinkNode root = new DFtrilinkNode();
    
    public void insert(int toAdd)
    {
        DFtrilinkNode curNode = root;
        DFtrilinkItem tempItem = new DFtrilinkItem(toAdd);
        
        if (curNode.value1 != null)
        {
            if (curNode.value2 == null)
            {
                curNode.insertItem(tempItem);
                curNode.flag2 = true;
            }
        }
        else if (curNode.isLeaf())
        {
            break;
        }
        else if (curNode.value1 != null)
        {
            curNode.insertItem(tempItem);
            curNode.flag1 = true;
        }
        
    }
    
    public int find(int key)
    {
        DFtrilinkNode curNode = root;
        int childNumber;
        
        while(true)
        {
            if ((childNumber = curNode.findItem(key)) != -1)
                return childNumber;
            else if (curNode.isLeaf())
                return -1;
        }
    }
    
    public int countNodes(DFtrilinkNode node)
    {
        int count = 1;
        if (node.parent != null)
        {
            count += countNodes(node.parent);
        }
        if (node.low != null)
        {
            count += countNodes(node.low);
        }
        if (node.medium != null)
        {
            count += countNodes(node.medium);
        }
        if (node.high != null)
        {
            count += countNodes(node.high);
        }
        return count;
    }
    
    public void delete(int toDelete)
    {
        DFtrilinkNode tempDelete = root;
        
        if (tempDelete.value1 == toDelete)
        {
            tempDelete.flag1 = false;
        }
        else if (tempDelete.value2 == toDelete)
        {
            tempDelete.flag2 = false;
        }
        else
        {
            
        }
    }
}
