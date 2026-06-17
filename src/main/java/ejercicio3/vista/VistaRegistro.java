package ejercicio3.vista;

import ejercicio3.modelo.Concurso;
import ejercicio3.modelo.ConcursoDAO;
import ejercicio3.modelo.Inscripto;
import ejercicio3.modelo.InscriptoDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaRegistro {
    private JPanel contentPane;
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblId;
    private JTextField txtId;
    private JLabel lblPhone;
    private JTextField txtPhone;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JComboBox<Concurso> comboBox;
    private JButton btnOk;
    private JLabel lblCompetition;
    private ConcursoDAO concursoDAO;
    private InscriptoDAO inscriptoDAO;

    public VistaRegistro(ConcursoDAO concursoDAO, InscriptoDAO inscriptoDAO) {
        this.concursoDAO = concursoDAO;
        this.inscriptoDAO = inscriptoDAO;
        var frame = new JFrame("Inscription to Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 451, 229);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        formElements();
        layout();
        frame.setVisible(true);

    }

    private void formElements() {
        lblName = new JLabel("Nombre:");
        txtName = new JTextField();
        txtName.setColumns(10);
        lblLastName = new JLabel("Apellido:");
        txtLastName = new JTextField();
        txtLastName.setColumns(10);
        lblId = new JLabel("Dni:");
        txtId = new JTextField();
        txtId.setColumns(10);
        lblPhone = new JLabel("Telefono:");
        txtPhone = new JTextField();
        txtPhone.setColumns(10);
        lblEmail = new JLabel("Email:");
        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        btnOk = new JButton("Ok");
        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOk.setEnabled(false);
                saveInscription();
                btnOk.setEnabled(true);
            }
        });
        lblCompetition = new JLabel("Concurso:");
        comboBox = new JComboBox<Concurso>();
        todosLosConcursos();
    }

    private void todosLosConcursos() {
        //concursoDAO.todosLosConcursos().forEach(concurso -> comboBox.addItem(concurso.getNombre()));
        concursoDAO.todosLosConcursos().forEach(concurso -> comboBox.addItem(concurso)); // cambie para q almacenara concursos para no tener que llamar a un metodo para recuperar el concurso cuando me toque guardar el id
    }

    private void saveInscription() {
        try {
            if (!validations()) { //ya estan estas validaciones tambien en los constructores
                return;
            }
            Concurso concursoSeleccionado = (Concurso) comboBox.getSelectedItem();
            if (concursoSeleccionado == null) {
                JOptionPane.showMessageDialog(this.contentPane, "no selecciono el concurso");
                return;
            }

            Inscripto inscripto = new Inscripto(txtName.getText(), txtLastName.getText(), txtId.getText(), txtPhone.getText(), txtEmail.getText());
            //Concurso concursoSeleccionado = (Concurso) comboBox.getSelectedItem();
            inscriptoDAO.saveInscription(inscripto, concursoSeleccionado.getId());

            JOptionPane.showMessageDialog(this.contentPane, "Inscripto registrado");
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this.contentPane, "Error " + e.getMessage());
        }
    }

    private boolean validations() {
        if ("".equals(txtName.getText())) {
            JOptionPane.showMessageDialog(this.contentPane, "Nombre no puede ser vacio");
            return false;
        }
        if ("".equals(txtLastName.getText())) {
            JOptionPane.showMessageDialog(this.contentPane, "apellido no puede ser vacio");
            return false;
        }
        if ("".equals(txtId.getText())) {
            JOptionPane.showMessageDialog(this.contentPane, "dni no puede ser vacio");
            return false;
        }
        if (!checkEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this.contentPane, "email debe ser válido");
            return false;
        }
        if (!checkPhone(txtPhone.getText())) {
            JOptionPane.showMessageDialog(this.contentPane, "El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
            return false;
        }
//        if (this.comboBox.getSelectedIndex() <= 0) {
//            JOptionPane.showMessageDialog(this.contentPane, "Debe elegir un Concurso");
//            return false;
//        }
        return true;
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    private void layout() {
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lblLastName).addComponent(lblId).addComponent(lblPhone).addComponent(lblEmail).addComponent(lblName).addComponent(lblCompetition)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE).addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(txtEmail, GroupLayout.Alignment.TRAILING).addComponent(txtPhone, GroupLayout.Alignment.TRAILING).addComponent(txtId, GroupLayout.Alignment.TRAILING).addComponent(txtLastName, GroupLayout.Alignment.TRAILING).addComponent(txtName, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))).addComponent(btnOk, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)).addContainerGap()));
        gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(lblName)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lblLastName).addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(lblId).addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(gl_contentPane.createSequentialGroup().addComponent(lblPhone).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lblEmail)).addGroup(gl_contentPane.createSequentialGroup().addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(gl_contentPane.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(lblCompetition)))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(btnOk).addContainerGap(67, Short.MAX_VALUE)));
        contentPane.setLayout(gl_contentPane);
    }
}

