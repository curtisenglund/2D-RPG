public class Inventory 
{
    public void openInventory(int option, Stack<Integer> stack, Stack<Integer> temp, Stack<Integer> basura, Hero hero) {         
        boolean check = true;

        while (check == true){
            if (option == stack.peek()) {
                int x = stack.peek();
                useItem(x, hero);
                basura.push(stack.pop());
                check = false;
            } else {
                temp.push(stack.pop());
            }
        }
        if (option != 10){
            putBack(stack, temp);
        }
    }
    
    public void putBack (Stack<Integer> stack, Stack<Integer> temp){
        //resets temp and stack after searching
        while (temp.isEmpty() == false){
            stack.push(temp.pop());
        //} 
        }
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