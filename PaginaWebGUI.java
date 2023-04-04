import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class PaginaWebGUI extends JFrame {

    private JEditorPane editorPagina;
    private JTextField enderecoTxt;

    public PaginaWebGUI() {
        super("Abrir Página Web");

        // Cria o componente JEditorPane para exibir a página web
        editorPagina = new JEditorPane();
        editorPagina.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(editorPagina);

        // Cria a caixa de texto para digitar o endereço
        enderecoTxt = new JTextField();
        enderecoTxt.setPreferredSize(new Dimension(300, 25));

        // Cria o botão para abrir a página
        JButton abrirBtn = new JButton("Abrir");
        abrirBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    URL url = new URL(enderecoTxt.getText());
                    editorPagina.setPage(url);
                } catch (MalformedURLException ex) {
                    JOptionPane.showMessageDialog(PaginaWebGUI.this, "Endereço inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(PaginaWebGUI.this, "Não foi possível carregar a página", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Cria o botão para fechar o programa
        JButton fecharBtn = new JButton("Fechar");
        fecharBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Adiciona os componentes na interface gráfica
        JPanel panel = new JPanel();
        panel.add(enderecoTxt);
        panel.add(abrirBtn);
        panel.add(fecharBtn);
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Configura o tamanho e a visibilidade da janela
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PaginaWebGUI();
            }
        });
    }
}






