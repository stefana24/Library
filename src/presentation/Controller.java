package presentation;

import dao.BookDao;
import model.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Controller {

    private View view;

    public Controller(){
        view = new View();
        this.view.addBtnBookListener(new ViewListener());
        this.view.updateBtnBookListener(new ViewListener());
        this.view.deleteBtnBookListener(new ViewListener());
        this.view.displayBtnBookListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                List<Book> allBooks = BookDao.displayAll();
                for(int i=0;i<allBooks.size();i++){
                    view.getDisplayField().append(allBooks.get(i).getTitle()+" "+allBooks.get(i).getAuthor()+" "+allBooks.get(i).getNumber());
                    view.getDisplayField().append("\n");
                }

            }
        });
    }

    public class ViewListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            String title = view.getBookTitleTF().getText();
            String author = view.getBookAuthorTF().getText();
            int no = Integer.parseInt(view.getBookNoTF().getText());
            Book book = new Book(title,author,no);

            switch (button){
                case "Insert book":
                    BookDao.insert(book);
                    break;
                case "Delete book":
                    BookDao.delete(book.getTitle());
                    break;
                case "Update book":
                    BookDao.update(book.getTitle(), book.getNumber()+1);
                    break;
            }

        }
    }
}
