/*
 * Created by JFormDesigner on Tue Apr 27 17:35:15 CST 2021
 */

package cc.niushuai.cleveronitor.gui;

import java.awt.event.*;

import cc.niushuai.cleveronitor.entity.DataValue;
import cc.niushuai.cleveronitor.entity.Machine;
import cc.niushuai.cleveronitor.util.Constants;
import cc.niushuai.cleveronitor.util.DialogUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.*;

/**
 * @author unknown
 */
public class MainFrame extends JFrame {

    public MainFrame() {
        initComponents();

        initMachineList();

        initData();
    }

    private void initMachineList() {
        String url = Constants.DEFAULT_URL_PREFIX + Constants.SEARCH_MACHINE;
        try {
            String res = HttpUtil.get(url);

            Constants.MACHINE_SET = JSONObject.parseArray(res, Machine.class).stream().collect(Collectors.toSet());

            initSelectData();
        } catch (Exception e) {
            e.printStackTrace();
            DialogUtil.showDialog("初始化设备信息失败, \nurl: " + url + "\nmsg: " + e.getMessage());
        }
    }

    private void initData() {

        initSelectData();
    }

    private void initSelectData() {
        Set<Machine> machineSet = Constants.MACHINE_SET;
        if (CollectionUtil.isNotEmpty(machineSet)) {
            comboBoxMachine.removeAllItems();
            List<Machine> collect = machineSet.stream().collect(Collectors.toList()).stream().sorted(Comparator.comparingInt(Machine::getMachineStationId)).collect(Collectors.toList());
            for (Machine machine : collect) {
                comboBoxMachine.addItem(StrUtil.join("",
                        "ID: ",machine.getId(),
                        " Name: ", machine.getMachineNo(),
                        " MachineName ", machine.getMachineName(),
                        "  站点ID: ", machine.getMachineStationId())
                );
            }
        }
    }

    private void comboBoxMachineItemStateChanged(ItemEvent e) {
        if (e.getStateChange() == 1) {
            String selectItemValue = e.getItem().toString();

            String sub = selectItemValue.substring(4);
            sub = sub.substring(0, sub.indexOf(" "));
            Constants.CURRENT_SELECT_ID = Long.valueOf(sub);
        }
    }

    private void updateButtonMouseClicked(MouseEvent e) {
        Constants.DEFAULT_URL_PREFIX = apiTextField.getText();
        DialogUtil.showDialog("接口地址前缀已更改为: " + Constants.DEFAULT_URL_PREFIX);
    }

    private void searchButtonMouseClicked(MouseEvent e) {
        setTextField(new DataValue());

        String res = null;
        String url = StrUtil.join("", Constants.DEFAULT_URL_PREFIX, Constants.SEARCH_MACHINE_PARAM_VALUE, Constants.CURRENT_SELECT_ID);
        try {
            res = HttpUtil.get(url);
            if (res.equals("{}")) {
                DialogUtil.showDialog("未查询到相关数据");
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            DialogUtil.showDialog("请求失败, \nurl: " + url + "\nmsg: " + exception.getMessage());
            return;
        }

        DataValue dv = null;
        try {
            dv = JSONObject.parseObject(res, DataValue.class);
        } catch (Exception exception) {
            exception.printStackTrace();
            DialogUtil.showDialog("封装对象失败, \nurl: " + url + "\nmsg: " + exception.getMessage() + "\nres: " + res);
        }

        setTextField(dv);

    }

    private void setTextField(DataValue dv) {
        textField0.setText(dv.get_0x0000());
        textField1.setText(dv.get_0x0001());
        textField2.setText(dv.get_0x0002());
        textField3.setText(dv.get_0x0003());
        textField4.setText(dv.get_0x0004());
        textField5.setText(dv.get_0x0005());
        textField6.setText(dv.get_0x0006());
        textField7.setText(dv.get_0x0007());
        textField8.setText(dv.get_0x0008());
        textField9.setText(dv.get_0x0009());
        textField10.setText(dv.get_0x000A());
        textField11.setText(dv.get_0x000B());
        textField12.setText(dv.get_0x000C());
        textField13.setText(dv.get_0x000D());
        textField14.setText(dv.get_0x000E());
        textField15.setText(dv.get_0x000F());
        textField16.setText(dv.get_0x0010());
        textField17.setText(dv.getHC());
    }

    private void updateMachineButtonMouseClicked(MouseEvent e) {
        initMachineList();
    }

    private void initComponents() {

//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        testLabel = new JLabel();
        apiTextField = new JTextField();
        updateButton = new JButton();
        updateMachineButton = new JButton();
        label1 = new JLabel();
        comboBoxMachine = new JComboBox();
        searchButton = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        label0 = new JLabel();
        textField0 = new JTextField();
        label10 = new JLabel();
        textField1 = new JTextField();
        label11 = new JLabel();
        textField2 = new JTextField();
        label12 = new JLabel();
        textField3 = new JTextField();
        label13 = new JLabel();
        textField4 = new JTextField();
        label14 = new JLabel();
        textField5 = new JTextField();
        label15 = new JLabel();
        textField6 = new JTextField();
        label16 = new JLabel();
        textField7 = new JTextField();
        label17 = new JLabel();
        textField8 = new JTextField();
        label18 = new JLabel();
        textField9 = new JTextField();
        label19 = new JLabel();
        textField10 = new JTextField();
        label20 = new JLabel();
        textField11 = new JTextField();
        label21 = new JLabel();
        textField12 = new JTextField();
        label22 = new JLabel();
        textField13 = new JTextField();
        label23 = new JLabel();
        textField14 = new JTextField();
        label24 = new JLabel();
        textField15 = new JTextField();
        label25 = new JLabel();
        textField16 = new JTextField();
        label26 = new JLabel();
        textField17 = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {76, 77, 67, 0, 43, 0, 42, 0, 44, 0, 45, 0, 66, 36, 41, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- testLabel ----
        testLabel.setText("\u514b\u83b1\u6c83\u8fde\u63a5\u7a0b\u5e8f\u53c2\u6570\u503c\u8bfb\u53d6\u5de5\u5177");
        contentPane.add(testLabel, new GridBagConstraints(0, 0, 16, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- apiTextField ----
        apiTextField.setText("http://localhost:5900");
        contentPane.add(apiTextField, new GridBagConstraints(1, 1, 10, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- updateButton ----
        updateButton.setText("\u4fee\u6539");
        updateButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateButtonMouseClicked(e);
            }
        });
        contentPane.add(updateButton, new GridBagConstraints(12, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- updateMachineButton ----
        updateMachineButton.setText("\u66f4\u65b0\u8bbe\u5907\u4fe1\u606f");
        updateMachineButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                updateMachineButtonMouseClicked(e);
            }
        });
        contentPane.add(updateMachineButton, new GridBagConstraints(14, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label1 ----
        label1.setText(" ");
        contentPane.add(label1, new GridBagConstraints(0, 2, 16, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- comboBoxMachine ----
        comboBoxMachine.addItemListener(e -> comboBoxMachineItemStateChanged(e));
        contentPane.add(comboBoxMachine, new GridBagConstraints(2, 3, 9, 2, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- searchButton ----
        searchButton.setText("\u67e5\u8be2");
        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchButtonMouseClicked(e);
            }
        });
        contentPane.add(searchButton, new GridBagConstraints(12, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label2 ----
        label2.setText(" ");
        contentPane.add(label2, new GridBagConstraints(0, 4, 16, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));

        //---- label3 ----
        label3.setText(" ");
        contentPane.add(label3, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label0 ----
        label0.setText("0x0000");
        contentPane.add(label0, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField0 ----
        textField0.setEditable(false);
        textField0.setEnabled(false);
        textField0.setBackground(Color.BLACK);
        textField0.setForeground(Color.WHITE);
        contentPane.add(textField0, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label10 ----
        label10.setText("0x0001");
        contentPane.add(label10, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField1 ----
        textField1.setEditable(false);
        textField1.setEnabled(false);
        textField1.setBackground(Color.BLACK);
        textField1.setForeground(Color.WHITE);
        contentPane.add(textField1, new GridBagConstraints(4, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label11 ----
        label11.setText("0x0002");
        contentPane.add(label11, new GridBagConstraints(5, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField2 ----
        textField2.setEditable(false);
        textField2.setEnabled(false);
        textField2.setBackground(Color.BLACK);
        textField2.setForeground(Color.WHITE);
        contentPane.add(textField2, new GridBagConstraints(6, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label12 ----
        label12.setText("0x0003");
        contentPane.add(label12, new GridBagConstraints(7, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField3 ----
        textField3.setEditable(false);
        textField3.setEnabled(false);
        textField3.setBackground(Color.BLACK);
        textField3.setForeground(Color.WHITE);
        contentPane.add(textField3, new GridBagConstraints(8, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label13 ----
        label13.setText("0x0004");
        contentPane.add(label13, new GridBagConstraints(9, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField4 ----
        textField4.setEditable(false);
        textField4.setEnabled(false);
        textField4.setBackground(Color.BLACK);
        textField4.setForeground(Color.WHITE);
        contentPane.add(textField4, new GridBagConstraints(10, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label14 ----
        label14.setText("0x0005");
        contentPane.add(label14, new GridBagConstraints(11, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField5 ----
        textField5.setEditable(false);
        textField5.setEnabled(false);
        textField5.setBackground(Color.BLACK);
        textField5.setForeground(Color.WHITE);
        contentPane.add(textField5, new GridBagConstraints(12, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label15 ----
        label15.setText("0x0006");
        contentPane.add(label15, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField6 ----
        textField6.setEditable(false);
        textField6.setEnabled(false);
        textField6.setBackground(Color.BLACK);
        textField6.setForeground(Color.WHITE);
        contentPane.add(textField6, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label16 ----
        label16.setText("0x0007");
        contentPane.add(label16, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField7 ----
        textField7.setEditable(false);
        textField7.setEnabled(false);
        textField7.setBackground(Color.BLACK);
        textField7.setForeground(Color.WHITE);
        contentPane.add(textField7, new GridBagConstraints(4, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label17 ----
        label17.setText("0x0008");
        contentPane.add(label17, new GridBagConstraints(5, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField8 ----
        textField8.setEditable(false);
        textField8.setEnabled(false);
        textField8.setBackground(Color.BLACK);
        textField8.setForeground(Color.WHITE);
        contentPane.add(textField8, new GridBagConstraints(6, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label18 ----
        label18.setText("0x0009");
        contentPane.add(label18, new GridBagConstraints(7, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField9 ----
        textField9.setEditable(false);
        textField9.setEnabled(false);
        textField9.setBackground(Color.BLACK);
        textField9.setForeground(Color.WHITE);
        contentPane.add(textField9, new GridBagConstraints(8, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label19 ----
        label19.setText("0x000A");
        contentPane.add(label19, new GridBagConstraints(9, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField10 ----
        textField10.setEditable(false);
        textField10.setEnabled(false);
        textField10.setBackground(Color.BLACK);
        textField10.setForeground(Color.WHITE);
        contentPane.add(textField10, new GridBagConstraints(10, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label20 ----
        label20.setText("0x000B");
        contentPane.add(label20, new GridBagConstraints(11, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField11 ----
        textField11.setEditable(false);
        textField11.setEnabled(false);
        textField11.setBackground(Color.BLACK);
        textField11.setForeground(Color.WHITE);
        contentPane.add(textField11, new GridBagConstraints(12, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label21 ----
        label21.setText("0x000C");
        contentPane.add(label21, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.NONE,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField12 ----
        textField12.setEditable(false);
        textField12.setEnabled(false);
        textField12.setBackground(Color.BLACK);
        textField12.setForeground(Color.WHITE);
        contentPane.add(textField12, new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label22 ----
        label22.setText("0x000D");
        contentPane.add(label22, new GridBagConstraints(3, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField13 ----
        textField13.setEnabled(false);
        textField13.setEditable(false);
        textField13.setBackground(Color.BLACK);
        textField13.setForeground(Color.WHITE);
        contentPane.add(textField13, new GridBagConstraints(4, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label23 ----
        label23.setText("0x000E");
        contentPane.add(label23, new GridBagConstraints(5, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField14 ----
        textField14.setEditable(false);
        textField14.setEnabled(false);
        textField14.setBackground(Color.BLACK);
        textField14.setForeground(Color.WHITE);
        contentPane.add(textField14, new GridBagConstraints(6, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label24 ----
        label24.setText("0x000F");
        contentPane.add(label24, new GridBagConstraints(7, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField15 ----
        textField15.setEditable(false);
        textField15.setEnabled(false);
        textField15.setBackground(Color.BLACK);
        textField15.setForeground(Color.WHITE);
        contentPane.add(textField15, new GridBagConstraints(8, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label25 ----
        label25.setText("0x0010");
        contentPane.add(label25, new GridBagConstraints(9, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField16 ----
        textField16.setEditable(false);
        textField16.setEnabled(false);
        textField16.setBackground(Color.BLACK);
        textField16.setForeground(Color.WHITE);
        contentPane.add(textField16, new GridBagConstraints(10, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label26 ----
        label26.setText("HC");
        contentPane.add(label26, new GridBagConstraints(11, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- textField17 ----
        textField17.setEditable(false);
        textField17.setEnabled(false);
        textField17.setBackground(Color.BLACK);
        textField17.setForeground(Color.WHITE);
        contentPane.add(textField17, new GridBagConstraints(12, 10, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));
        setSize(870, 380);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel testLabel;
    private JTextField apiTextField;
    private JButton updateButton;
    private JButton updateMachineButton;
    private JLabel label1;
    private JComboBox comboBoxMachine;
    private JButton searchButton;
    private JLabel label2;
    private JLabel label3;
    private JLabel label0;
    private JTextField textField0;
    private JLabel label10;
    private JTextField textField1;
    private JLabel label11;
    private JTextField textField2;
    private JLabel label12;
    private JTextField textField3;
    private JLabel label13;
    private JTextField textField4;
    private JLabel label14;
    private JTextField textField5;
    private JLabel label15;
    private JTextField textField6;
    private JLabel label16;
    private JTextField textField7;
    private JLabel label17;
    private JTextField textField8;
    private JLabel label18;
    private JTextField textField9;
    private JLabel label19;
    private JTextField textField10;
    private JLabel label20;
    private JTextField textField11;
    private JLabel label21;
    private JTextField textField12;
    private JLabel label22;
    private JTextField textField13;
    private JLabel label23;
    private JTextField textField14;
    private JLabel label24;
    private JTextField textField15;
    private JLabel label25;
    private JTextField textField16;
    private JLabel label26;
    private JTextField textField17;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
