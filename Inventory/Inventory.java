public class Inventory 
{
    public void openInventory(int option, Stack<Integer> stack, Stack<Integer> temp, Stack<Integer> basura, Hero hero) {         
            boolean check = true;

            while (check == true){
            if (option == stack.peek()){
                int x = stack.peek();
                useItem(x, hero);
                basura.push(stack.pop(stack.getTopIndex()));
                check = false;
            } else {
                temp.push(stack.pop(stack.getTopIndex()));
            }
        }
        putBack(stack, temp);
    }

    public void putBack (Stack<Integer> stack, Stack<Integer> temp){
        //while (temp.isEmpty() == false){
            //resets temp and stack after searching
        for (int i = stack.getTopIndex(); i < stack.getMaxSize(); i ++){
            stack.push(temp.pop(temp.getTopIndex()));
        } 
        //}
    }


    public void useItem(int x, Hero hero)
    {
        switch (x){
            case 10:
                hero.setHealthItem (10);
                break;
            case 20:
                hero.setHealthItem (20);
                break;
            case 50:
                hero.setHealthItem(50);
                break;
        }
    }
}