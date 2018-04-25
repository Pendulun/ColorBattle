/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testestile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import static java.lang.Thread.sleep;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Tile extends JPanel {

    private int tileHeight = 0, tileWidth = 0, escala = 10, nH = 0, nV = 0;

    public int getnH() {
        return nH;
    }

    public void setnH(int nH) {
        this.nH = nH;
    }

    public int getnV() {
        return nV;
    }

    public void setnV(int nV) {
        this.nV = nV;
    }
    private Color cor;
    private Graphics2D g2;
    private Graphics gra;
    private int[][] matrizmapa;

    public int getEscala() {
        return escala;
    }

    public void setEscala(int escala) {
        this.escala = escala;
    }

    public void setG2() {
        this.g2 = (Graphics2D) gra;
    }

    public Graphics2D getG2() {
        return g2;
    }

    public Graphics getGra() {
        return gra;
    }

    public void setGra(Graphics gra) {
        this.gra = gra;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
        g2.setColor(cor);
    }

    public void pintaQuadrado(int x, int y) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        int x1 = (int) x;
        int y1 = (int) y;
        g2.fillRect(x1 - (int) (escala / 2), y1 - (int) (escala / 2), this.escala, this.escala);
    }

    public void geraCorAleatoria() {
        int cor1 = (int) (Math.random() * 12);
        switch (cor1) {
            case 0://verde escuro
                g2.setColor(new Color(0, 153, 0));
                break;
            case 1://verde claro
                g2.setColor(new Color(51, 255, 51));
                break;
            case 2://verde opaco
                g2.setColor(new Color(153, 255, 153));
                break;
            case 3://azul escuro
                g2.setColor(new Color(51, 102, 255));
                break;
            case 4://azul mais ou menos
                g2.setColor(new Color(102, 153, 255));
                break;
            case 5://azul claro
                g2.setColor(new Color(102, 204, 255));
                break;
            case 6://laranja
                g2.setColor(new Color(255, 153, 51));
                break;
            case 7://castanho
                g2.setColor(new Color(65, 62, 53));
                break;
            case 8://areia
                g2.setColor(new Color(58, 81, 96));
                break;
            case 9://deserto
                g2.setColor(new Color(58, 81, 96));
                break;
            case 10://cinza leve
                g2.setColor(new Color(58, 2, 91));
                break;
            case 11://branco
                g2.setColor(new Color(58, 0, 100));
                break;
            default:
                System.out.println("nenhuma das cores");
                break;
        }

    }

    public void geraCor(int cor1) {
        switch (cor1) {
            case 0://verde escuro
                g2.setColor(new Color(0, 153, 0));
                break;
            case 1://verde claro
                g2.setColor(new Color(51, 255, 51));
                break;
            case 2://verde opaco
                g2.setColor(new Color(153, 255, 153));
                break;
            case 3://azul escuro
                g2.setColor(new Color(51, 102, 255));
                break;
            case 4://azul mais ou menos
                g2.setColor(new Color(102, 153, 255));
                break;
            case 5://azul claro
                g2.setColor(new Color(102, 204, 255));
                break;
            case 6://laranja
                g2.setColor(new Color(255, 153, 51));
                break;
            case 7://castanho
                g2.setColor(new Color(151, 52, 0));
                break;
            case 8://areia
                g2.setColor(new Color(58, 81, 96));
                break;
            case 9://deserto
                g2.setColor(new Color(58, 81, 96));
                break;
            case 10://cinza leve
                g2.setColor(new Color(58, 2, 91));
                break;
            case 11://branco
                g2.setColor(new Color(255, 255, 255));
                break;
            default:
                System.out.println("nenhuma das cores");
                break;
        }

    }

//    public int[][] defineMapa(int escala){
//        int[][] mapa;
//        switch(escala){
//            case 0:
//                
//        }
//        return mapa;
//    }
    public boolean confereOrdem(int cor1, int cor2, boolean d) {
        int op = 0;//1 - ganha, 2 - perde
        double prob = 0.0;
        switch (cor1) {
            case 0://verde escuro
                if (cor2 == 1 || cor2 == 2) {
                    prob = 5.0;
                } else if (cor2 == 3 || cor2 == 4) {
                    prob = 4.5;
                } else if (cor2 >= 5 && cor2 <= 7) {
                    prob = 4.0;
                } else if (cor2 == 8 || cor2 == 9) {
                    prob = 3.5;
                } else if (cor2 == 10) {
                    prob = 3.0;
                } else if (cor2 == 11) {
                    if (d) {
                        prob = 2.5;
                    } else {
                        prob = 10.0;
                    }
                }
                break;
            case 1://verde claro
                if (cor2 == 2 || cor2 == 3) {
                    prob = 5.0;
                } else if (cor2 == 4 || cor2 == 5) {
                    prob = 4.5;
                } else if (cor2 >= 6 && cor2 <= 8) {
                    prob = 4.0;
                } else if (cor2 == 9 || cor2 == 10) {
                    prob = 3.5;
                } else if (cor2 == 11) {
                    if (d) {
                        prob = 3.0;
                    } else {
                        prob = 10.0;
                    }
                } else if (cor2 == 0) {
                    prob = 5.0;
                }
                break;
            case 2://verde opaco
                if (cor2 == 3 || cor2 == 4) {
                    prob = 5.0;
                } else if (cor2 == 5 || cor2 == 6) {
                    prob = 4.5;
                } else if (cor2 >= 7 && cor2 <= 9) {
                    prob = 4.0;
                } else if (cor2 == 10 || cor2 == 11) {
                    prob = 3.5;
                    if (cor2 == 11) {
                        if (!d) {
                            prob = 10.0;
                        }
                    }
                } else if (cor2 == 0 || cor2 == 1) {
                    prob = 5.0;
                }
                break;
            case 3://azul escuro
                if (cor2 == 4 || cor2 == 5) {
                    prob = 5.0;
                } else if (cor2 == 6 || cor2 == 7) {
                    prob = 4.5;
                } else if (cor2 >= 8 && cor2 <= 10) {
                    prob = 4.0;
                } else if (cor2 == 11) {
                    if (d) {
                        prob = 3.5;
                    } else {
                        prob = 10.0;
                    }
                } else if (cor2 == 1 || cor2 == 2) {
                    prob = 5.0;
                } else if (cor2 == 0) {
                    prob = 5.5;
                }
                break;
            case 4://azul mais ou menos
                if (cor2 == 5 || cor2 == 6) {
                    prob = 5.0;
                } else if (cor2 == 7 || cor2 == 8) {
                    prob = 4.5;
                } else if (cor2 >= 9 && cor2 <= 11) {
                    prob = 4.0;
                    if (cor2 == 11) {
                        if (!d) {
                            prob = 10.0;
                        }
                    }
                } else if (cor2 == 2 || cor2 == 3) {
                    prob = 5.0;
                } else if (cor2 == 0 || cor2 == 1) {
                    prob = 5.5;
                }
                break;
            case 5://azul claro
                if (cor2 == 6 || cor2 == 7) {
                    prob = 5.0;
                } else if (cor2 == 8 || cor2 == 9) {
                    prob = 4.5;
                } else if (cor2 == 10 || cor2 == 11) {
                    prob = 4.0;
                    if (cor2 == 11) {
                        if (!d) {
                            prob = 10.0;
                        }
                    }
                } else if (cor2 == 3 || cor2 == 4) {
                    prob = 5.0;
                } else if (cor2 == 1 || cor2 == 2) {
                    prob = 5.5;
                } else if (cor2 == 0) {
                    prob = 6.0;
                }
                break;
            case 6://laranja
                if (cor2 == 7 || cor2 == 8) {
                    prob = 5.0;
                } else if (cor2 == 9 || cor2 == 10) {
                    prob = 4.5;
                } else if (cor2 == 11) {
                    if (d) {
                        prob = 4.0;
                    } else {
                        prob = 10.0;
                    }
                } else if (cor2 == 4 || cor2 == 5) {
                    prob = 5.0;
                } else if (cor2 == 2 || cor2 == 3) {
                    prob = 5.5;
                } else if (cor2 == 0 || cor2 == 1) {
                    prob = 6.0;
                }
                break;
            case 7://castanho
                if (cor2 == 8 || cor2 == 9) {
                    prob = 5.0;
                } else if (cor2 == 10 || cor2 == 11) {
                    prob = 4.5;
                    if (cor2 == 11) {
                        if (!d) {
                            prob = 10.0;
                        }
                    }
                } else if (cor2 == 5 || cor2 == 6) {
                    prob = 5.0;
                } else if (cor2 == 4 || cor2 == 4) {
                    prob = 5.5;
                } else if (cor2 >= 0 && cor2 <= 2) {
                    prob = 6.0;
                }
                break;
            case 8://areia
                if (cor2 == 9 || cor2 == 10) {
                    prob = 5.0;
                } else if (cor2 == 11) {
                    if (d) {
                        prob = 4.5;
                    } else {
                        prob = 10;
                    }
                } else if (cor2 == 6 || cor2 == 7) {
                    prob = 5.0;
                } else if (cor2 == 4 || cor2 == 5) {
                    prob = 5.5;
                } else if (cor2 >= 1 && cor2 <= 3) {
                    prob = 6.0;
                } else if (cor2 == 0) {
                    prob = 6.5;
                }
                break;
            case 9://deserto
                if (cor2 == 10 || cor2 == 11) {
                    prob = 5.0;
                    if (cor2 == 11) {
                        if (!d) {
                            prob = 10.0;
                        }
                    }
                } else if (cor2 == 7 || cor2 == 8) {
                    prob = 5.0;
                } else if (cor2 == 5 || cor2 == 6) {
                    prob = 5.5;
                } else if (cor2 >= 2 && cor2 <= 4) {
                    prob = 6.0;
                } else if (cor2 == 0 || cor2 == 1) {
                    prob = 6.5;
                }
                break;
            case 10://cinza leve
                if (cor2 == 11) {
                    if (d) {
                        prob = 5.0;
                    } else {
                        prob = 10.0;
                    }
                } else if (cor2 == 8 || cor2 == 9) {
                    prob = 5.0;
                } else if (cor2 == 6 || cor2 == 7) {
                    prob = 5.5;
                } else if (cor2 >= 3 && cor2 <= 5) {
                    prob = 6.0;
                } else if (cor2 == 1 || cor2 == 2) {
                    prob = 6.5;
                } else if (cor2 == 0) {
                    prob = 7.0;
                }
                break;

            case 11://branco
                if (d) {
                    if (cor2 == 9 || cor2 == 10) {
                        prob = 5.0;
                    } else if (cor2 == 7 || cor2 == 8) {
                        prob = 5.5;
                    } else if (cor2 >= 4 && cor2 <= 6) {
                        prob = 6.0;
                    } else if (cor2 == 2 || cor2 == 3) {
                        prob = 6.5;
                    } else if (cor2 == 0 || cor2 == 1) {
                        prob = 7.0;
                    }
                } else {
                    return false;
                }
                break;
            default:
                break;
        }
        double result = Math.random() * 10;
        if (result <= prob) {
            return true;
        } else {
            return false;
        }
    }

    public void comecaBatalha(int c) {
        boolean d;
        if (c == 1) {
            d = false;
        } else {
            d = true;
        }
        for (int i = 0; i < nV; i++) {
            for (int u = 0; u < nH; u++) {
                int ver = 0;
                while (ver == 0) {
                    try {
                        int ale = (int) (Math.random() * 8);
                        boolean op = true;
                        switch (ale) {
                            case 0:
                                if (matrizmapa[u][i] != matrizmapa[u - 1][i - 1]) {
                                    op = confereOrdem(matrizmapa[u][i], matrizmapa[u - 1][i - 1], d);
                                    if (op) {
                                        geraCor(matrizmapa[u][i]);
                                        g2.fillRect((u - 1) * tileWidth, (i - 1) * tileHeight, tileWidth, tileHeight);
                                        matrizmapa[u - 1][i - 1] = matrizmapa[u][i];
                                    }
                                }
                                break;
                            case 1:
                                if (matrizmapa[u][i] != matrizmapa[u][i - 1]) {
                                    op = confereOrdem(matrizmapa[u][i], matrizmapa[u][i - 1], d);
                                    if (op) {
                                        geraCor(matrizmapa[u][i]);
                                        g2.fillRect(u * tileWidth, (i - 1) * tileHeight, tileWidth, tileHeight);
                                        matrizmapa[u][i - 1] = matrizmapa[u][i];
                                    }
                                }
                                break;
                            case 2:
                                if (matrizmapa[u][i] != matrizmapa[u + 1][i - 1]) {
                                    op = confereOrdem(matrizmapa[u][i], matrizmapa[u + 1][i - 1], d);
                                    if (op) {
                                        geraCor(matrizmapa[u][i]);
                                        g2.fillRect((u + 1) * tileWidth, (i - 1) * tileHeight, tileWidth, tileHeight);
                                        matrizmapa[u + 1][i - 1] = matrizmapa[u][i];
                                    }
                                }
                                break;
                            case 3:
                                if (matrizmapa[u][i] != matrizmapa[u - 1][i]) {
                                    op = confereOrdem(matrizmapa[u][i], matrizmapa[u - 1][i], d);
                                    if (op) {
                                        geraCor(matrizmapa[u][i]);
                                        g2.fillRect((u - 1) * tileWidth, i * tileHeight, tileWidth, tileHeight);
                                        matrizmapa[u - 1][i] = matrizmapa[u][i];
                                    }
                                }
                                break;
                            case 4:
                                if (matrizmapa[u][i] != matrizmapa[u + 1][i]) {
                                    op = confereOrdem(matrizmapa[u][i], matrizmapa[u + 1][i], d);
                                    if (op) {
                                        geraCor(matrizmapa[u][i]);
                                        g2.fillRect((u + 1) * tileWidth, i * tileHeight, tileWidth, tileHeight);
                                        matrizmapa[u + 1][i] = matrizmapa[u][i];
                                    }
                                }
                                break;
                            case 5:
                                if (matrizmapa[u][i] != matrizmapa[u - 1][i + 1]) {
                                    op = confereOrdem(matrizmapa[u][i], matrizmapa[u - 1][i + 1], d);
                                    if (op) {
                                        geraCor(matrizmapa[u][i]);
                                        g2.fillRect((u - 1) * tileWidth, (i + 1) * tileHeight, tileWidth, tileHeight);
                                        matrizmapa[u - 1][i + 1] = matrizmapa[u][i];
                                    }
                                }
                                break;
                            case 6:
                                if (matrizmapa[u][i] != matrizmapa[u][i + 1]) {
                                    op = confereOrdem(matrizmapa[u][i], matrizmapa[u][i + 1], d);
                                    if (op) {
                                        geraCor(matrizmapa[u][i]);
                                        g2.fillRect(u * tileWidth, (i + 1) * tileHeight, tileWidth, tileHeight);
                                        matrizmapa[u][i + 1] = matrizmapa[u][i];
                                    }
                                }
                                break;
                            case 7:
                                if (matrizmapa[u][i] != matrizmapa[u + 1][i + 1]) {
                                    op = confereOrdem(matrizmapa[u][i], matrizmapa[u + 1][i + 1], d);
                                    if (op) {
                                        geraCor(matrizmapa[u][i]);
                                        g2.fillRect((u + 1) * tileWidth, (i + 1) * tileHeight, tileWidth, tileHeight);
                                        matrizmapa[u + 1][i + 1] = matrizmapa[u][i];
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                        ver = 1;
                    } catch (Exception ex) {
                        //System.out.println("Erro!");
                        ver = 0;
                    }
                }
            }
        }
    }

    public void zeraPanel(Tile panel, Color cor) {
        g2.setColor(cor);
        g2.fillRect(0, 0, panel.getWidth(), panel.getHeight());
    }

    public void desenhaNeve(int vH, int vV) {
        geraCor(11);
        g2.fillRect(((vH - 1) * tileWidth), ((vV - 1) * tileHeight), tileWidth * 3, tileHeight * 3);
        g2.fillRect(((vH - 2) * tileWidth), (vV * tileHeight), tileWidth, tileHeight);
        g2.fillRect(((vH + 2) * tileWidth), (vV * tileHeight), tileWidth, tileHeight);
        g2.fillRect((vH * tileWidth), ((vV - 2) * tileHeight), tileWidth, tileHeight);
        g2.fillRect((vH * tileWidth), ((vV + 2) * tileHeight), tileWidth, tileHeight);
    }

    public void desenhaMontanhaComNeve(int nH, int nV) {
        geraCor(7);
        int vH = (int) (Math.random() * nH);
        int vV = (int) (Math.random() * nV);
        g2.fillRect(((vH - 2) * tileWidth), ((vV - 2) * tileHeight), tileWidth * 5, tileHeight * 5);
        g2.fillRect(((vH - 1) * tileWidth), ((vV - 3) * tileHeight), tileWidth * 3, tileHeight * 7);
        g2.fillRect(((vH - 3) * tileWidth), ((vV - 1) * tileHeight), tileWidth * 7, tileHeight * 3);
        g2.fillRect((vH * tileWidth), ((vV - 4) * tileHeight), tileWidth, tileHeight * 9);
        g2.fillRect(((vH - 4) * tileWidth), (vV * tileHeight), tileWidth * 9, tileHeight);
        desenhaNeve(vH, vV);
    }

    public void geraMatriz(int a) {
        matrizmapa = new int[nH][nV];
        if (a == 0) {
            for (int x = 0; x < nH; x++) {
                for (int y = 0; y < nV; y++) {
                    matrizmapa[x][y] = (int) (Math.random() * 12);
                }
            }
        }
        if (a == 1) {
            for (int x = 0; x < nH; x++) {
                for (int y = 0; y < nV; y++) {
                    matrizmapa[x][y] = 11;
                }
            }
            matrizmapa[0][0] = 0;
            matrizmapa[0][nV - 5] = 1;
            matrizmapa[0][(int) (nV / 2)] = 7;
            matrizmapa[nH - 1][0] = 2;
            matrizmapa[nH - 1][nV - 5] = 3;
            matrizmapa[nH - 1][(int) (nV / 2)] = 8;
            matrizmapa[(int) (nH / 2)][0] = 4;
            matrizmapa[(int) (nH / 2)][nV - 5] = 5;
            matrizmapa[(int) (nH / 2)][(int) (nV / 2)] = 6;
        }
    }

    public void desenhaGrid(Tile panel, int a) {
        zeraPanel(panel, Color.WHITE);
        nH = panel.getWidth() / tileWidth;
        nV = panel.getHeight() / tileHeight;
        geraMatriz(a);
// gera aleatório
//        for (int i1 = 0; i1 < nH; i1++) {
//            for (int i2 = 0; i2 < nV; i2++) {
//                geraCorAleatoria();
//                g2.fillRect(i1 * tileWidth, i2 * tileHeight, tileWidth, tileHeight);
//            }
//        }
//desenha as iamgens de montanhas com neve
//        zeraPanel(panel, Color.GREEN);
//        int cont = 0;
//        while (cont < 1) {
//            cont = (int) (Math.random() * 4);
//        }
//        for (int i = 0; i < cont; i++) {
//            desenhaMontanhaComNeve(nH, nV);
//        }
        for (int i1 = 0; i1 < nH; i1++) {
            for (int i2 = 0; i2 < nV; i2++) {
                geraCor(matrizmapa[i1][i2]);
                g2.fillRect(i1 * tileWidth, i2 * tileHeight, tileWidth, tileHeight);
            }
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        // GoalKicker.com – Java® Notes for Professionals  520
        // clear the previous painting
        super.paintComponent(g);
        // cast Graphics to Graphics2D
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(0, 0, this.getWidth(), this.getWidth());
    }

}
