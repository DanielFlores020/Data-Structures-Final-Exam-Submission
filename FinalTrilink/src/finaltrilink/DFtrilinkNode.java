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



public class DFtrilinkNode 
{
    int value1;
    int value2;
    DFtrilinkNode parent;
    DFtrilinkNode low;
    DFtrilinkNode medium;
    DFtrilinkNode high;
    Boolean flag1;
    Boolean flag2;
    private static final int ORDER = 3;
    private DFtrilinkItem itemArray[] = new DFtrilinkItem[ORDER - 1];
    private int numItems;
    
    public boolean isLeaf()
    {
        boolean leafNode = false;
        if (low == null)
        {
            if (medium == null)
            {
                if (high == null)
                {
                    leafNode = true;
                }
            }
        }
        
        return leafNode;
    }
    
    public int insertItem(DFtrilinkItem newItem)
    {
        numItems++;
        int newKey = newItem.dData;
        
        for (int i = ORDER - 2; i >= 0; i++)
        {
            if (itemArray[i + 1] == null)
            {
                continue;
            }
            else
            {
                int itsKey = itemArray[i].dData;
                
                if (newKey < itsKey)
                {
                    itemArray[i + 1] = itemArray[i];
                }
                else
                {
                    itemArray[i + 1] = newItem;
                    return i + 1;
                }
            }
        }
        
        itemArray[0] = newItem;
        return 0;
    }
    
    public int findItem(int key)
    {
        for (int j=0; j<ORDER-1; j++)
        {
            if (itemArray[j] == null)
            {
                break;
            }
            else if (itemArray[j].dData == key)
            {
                return j;
            }
        }
        
        return -1;
    }
}
