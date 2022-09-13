package h10;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * An object of this class represents a Linked List.
 *
 * @param <T> Type ListItem Objects saved in the LinkedList
 */
public class MyLinkedList<T> {
    public ListItem<T> head;

    /**
     * This method adds a new list item with parameter "key" as its key value to the end of the list.
     *
     * @param key key value of item to be added
     * @return boolean stating if the item has been added to the list successfully
     */
    public boolean add(T key) {
        if (head == null) {
            head = new ListItem<>(key);
            return true;
        }

        ListItem<T> p = head;

        while (p.next != null) {
            p = p.next;
        }

        p.next = new ListItem<>(key);
        return true;
    }

    /**
     * This method extracts all ListItems of the list in this.head iteratively if predT is true in a new list and returns it.
     * All items in that get extracted are also removed in the initial list.
     * @param predT predicate that tests a list object
     * @param fct returns a certain value for a list object key
     * @param predU if this is true exception gets thrown
     * @param <U> type of head
     * @return returns extracted list
     * @throws MyLinkedListException gets thrown when predU is true
     */
    public<U> MyLinkedList<U> extractIteratively(Predicate<? super T> predT, Function<? super T,? extends U> fct, Predicate<? super U> predU) throws MyLinkedListException {
        MyLinkedList<U> extractedList = new MyLinkedList<>();
        ListItem<T> oldP = null;
        ListItem<U> head = null;
        int index = 0;

        for(ListItem<T> p = this.head; p != null; p = p.next) {
            if(predT.test(p.key)) {

                if(!predU.test(fct.apply(p.key))) {
                    throw new MyLinkedListException(index, fct.apply(p.key));
                }

                if(extractedList.head == null) {
                    extractedList.head = new ListItem<>(fct.apply(p.key));
                    head = extractedList.head;
                } else {
                    head.next = new ListItem<>(fct.apply(p.key));
                    head = head.next;
                }

                if(p == this.head) {
                    this.head = p.next;
                    oldP = p.next;
                } else oldP.next = p.next;

            }else oldP = p;
            index++;
        }

        return extractedList;
    }

    /**
     * This method extracts all ListItems of the list in this.head recursively if predT is true in a new list and returns it.
     * All items in that get extracted are also removed in the initial list.
     * @param predT predicate that tests a list object
     * @param fct returns a certain value for a list object key
     * @param predU if this is true exception gets thrown
     * @param <U> type of head
     * @return returns extracted list
     * @throws MyLinkedListException gets thrown when predU is true
     */
    public <U> MyLinkedList<U> extractRecursively(Predicate<? super T> predT, Function<? super T,? extends U> fct, Predicate<? super U> predU) throws MyLinkedListException {
        MyLinkedList<U> extractedList;
        extractedList = extractRecursivelyHelper(predT, fct, predU, null, 0);
        return extractedList;
    }

    /**
     * This method does the actual recursion of extractRecursively.
     * @param predT predicate that tests a list object
     * @param fct returns a certain value for a list object key
     * @param predU if this is true exception gets thrown
     * @param pSrc is the ListItem before the ListItem that gets checked
     * @param index current position in the list
     * @param <U> type of head
     * @return returns extracted list
     * @throws MyLinkedListException gets thrown when predU is true
     */
    private <U> MyLinkedList<U> extractRecursivelyHelper(Predicate<? super T> predT, Function<? super T,? extends U> fct, Predicate<? super U> predU, ListItem<T> pSrc, int index) throws MyLinkedListException{
        MyLinkedList<U> extractedBody = new MyLinkedList<>();

        if(pSrc == null) {
            if(predT.test(this.head.key)) {
                if(!predU.test(fct.apply(this.head.key))) {
                    throw new MyLinkedListException(index, fct.apply(this.head.key));
                }

                extractedBody.head = new ListItem<>(fct.apply(this.head.key));
                this.head = this.head.next;
                extractedBody.head.next = (ListItem<U>) extractRecursivelyHelper(predT, fct, predU, null, ++index).head;
            } else {
                extractedBody.head = (ListItem<U>) extractRecursivelyHelper(predT, fct, predU, this.head, ++index).head;
            }
        } else {
            if(pSrc.next == null) {
                return extractedBody;
            }
            if(predT.test(pSrc.next.key)) {
                if(!predU.test(fct.apply(pSrc.next.key))) {
                    throw new MyLinkedListException(index, fct.apply(pSrc.next.key));
                }

                extractedBody.head = new ListItem<>(fct.apply(pSrc.next.key));
                pSrc.next = pSrc.next.next;
                if(pSrc.next != null) {
                    extractedBody.head.next = (ListItem<U>) extractRecursivelyHelper(predT,fct,predU,pSrc,++index).head;
                }
            } else extractedBody.head = (ListItem<U>) extractRecursivelyHelper(predT,fct,predU,pSrc.next,++index).head;
        }

        return extractedBody;
    }

    /**
     * This method merges the List in this.head and a otherList iteratively. The first item in the otherList get tested by biPred with
     * every Item in the this.head List. When bi Pred is true a new ListItem is added at this position with the fct value of the current otherList item.
     * @param otherList second list
     * @param biPred tests the Item of otherList and the main list in this.head
     * @param fct returns a certain value for a list object key
     * @param predU if this is true exception gets thrown
     * @param <U> type of head
     * @throws MyLinkedListException gets thrown when predU is true
     */
    public <U> void mixinIteratively(MyLinkedList<U> otherList, BiPredicate<? super T,? super U> biPred, Function<? super U,? extends T> fct, Predicate<? super U> predU) throws MyLinkedListException {
        ListItem<U> initialHead = otherList.head;
        ListItem<U> newListItem = otherList.head;
        ListItem<T> oldP = this.head;
        int index = 0;


        ListItem<U> itemThatGetsAdded = otherList.head.next;
        MyLinkedList<T> backUp = new MyLinkedList<>();
        backUp.head = new ListItem<>(fct.apply(otherList.head.key));
        ListItem<T> lastItem = backUp.head;
        ListItem<T> initialBackUp = backUp.head;



        for(ListItem<T> p = this.head; p != null; ) {
            if(!predU.test(otherList.head.key)) {
                throw new MyLinkedListException(index, otherList.head.key);
            }


            if(itemThatGetsAdded != null && predU.test(itemThatGetsAdded.key)) {
                lastItem.next = new ListItem<>(fct.apply(itemThatGetsAdded.key));
                itemThatGetsAdded = itemThatGetsAdded.next;
                continue;
            }else backUp.head = initialBackUp;

            if(biPred.test(p.key, newListItem.key)) {
                index++;
                backUp.head = backUp.head.next;
                if(p == this.head) {
                    this.head = new ListItem<>(fct.apply(otherList.head.key));
                    this.head.next = p;
                    otherList.head = otherList.head.next;
                }else {
                    oldP.next = new ListItem<>(fct.apply(otherList.head.key));
                    oldP.next.next = p;
                    otherList.head = otherList.head.next;
                }
            }
            oldP = p;
            p = p.next;
        }
        oldP.next = backUp.head;

        otherList.head = initialHead;
    }
    /**
     * This method merges the List in this.head and a otherList recursively. The first item in the otherList get tested by biPred with
     * every Item in the this.head List. When bi Pred is true a new ListItem is added at this position with the fct value of the current otherList item.
     * @param otherList second list
     * @param biPred tests the Item of otherList and the main list in this.head
     * @param fct returns a certain value for a list object key
     * @param predU if this is true exception gets thrown
     * @param <U> type of head
     * @throws MyLinkedListException gets thrown when predU is true
     */
    public <U> void mixinRecursively(MyLinkedList<U> otherList, BiPredicate<? super T,? super U> biPred, Function<? super U,? extends T> fct, Predicate<? super U> predU) throws MyLinkedListException {
        ListItem<U> initialHead = otherList.head;

        if(!predU.test(otherList.head.key)) {
            throw new MyLinkedListException(0, otherList.head.key);
        }

        if(biPred.test(this.head.key, otherList.head.key)) {
            ListItem<T> newItem = new ListItem<>(fct.apply(otherList.head.key));
            newItem.next = this.head;
            this.head = newItem;
            MyLinkedList<U> realList = new MyLinkedList<>();
            realList.head = otherList.head.next;

            mixinRecursivelyHelper(realList, biPred, fct, predU, realList.head, this.head.next, 1);
        } else mixinRecursivelyHelper(otherList, biPred, fct, predU, otherList.head, this.head, 0);

        otherList.head = initialHead;
    }

    /**
     * This method does the recursion for mixinRecursively.
     * @param otherList contains all Items that are left for testing
     * @param biPred tests the Item of otherList and the main list in this.head
     * @param fct returns a certain value for a list object key
     * @param predU if this is true exception gets thrown
     * @param pSrc current otherList item that gets tested
     * @param pDest item in the head list before the item that gets actually tested
     * @param index current position in otherList
     * @param <U> type of head
     * @throws MyLinkedListException gets thrown when predU is true
     */
    private <U> void mixinRecursivelyHelper(MyLinkedList<U> otherList, BiPredicate<? super T,? super U> biPred, Function<? super U,? extends T> fct, Predicate<? super U> predU, ListItem<U> pSrc, ListItem<T> pDest, int index) throws MyLinkedListException {
        int newIndex = index;

        if(pDest.next != null) {
            if(!predU.test(otherList.head.key)) {
                throw new MyLinkedListException(index, otherList.head.key);
            }

            if(biPred.test(pDest.next.key, pSrc.key)) {
                newIndex++;
                ListItem<T> newItem = new ListItem<>(fct.apply(pSrc.key));
                newItem.next = pDest.next;
                pDest.next = newItem;
                MyLinkedList<U> realList = new MyLinkedList<>();
                realList.head = otherList.head.next;

                mixinRecursivelyHelper(realList, biPred, fct, predU, realList.head, pDest.next.next, newIndex);
            } else mixinRecursivelyHelper(otherList, biPred, fct, predU, otherList.head, pDest, newIndex);
        } else {
            if(otherList.head != null) {
                if(!predU.test(otherList.head.key)) {
                    throw new MyLinkedListException(index, otherList.head.key);
                }
                pDest.next = new ListItem<>(fct.apply(otherList.head.key));
                MyLinkedList<U> realList = new MyLinkedList<>();
                realList.head = otherList.head.next;
                mixinRecursivelyHelper(realList, biPred, fct, predU, realList.head, pDest.next, newIndex);
            }
        }
    }
}
