/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testestile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Tile extends JPanel {

    private int tileHeight = 0, tileWidth = 0, escala = 10, nH = 0, nV = 0;
    private Color cor;
    private Graphics2D g2;
    private Graphics gra;
    private int[][] matrizmapa, matrizsecundaria;
    private Modificadores defesa, ataque = null;
    private ArrayList<Time> arrayTimes = new ArrayList();
    public static int k = 0;

    public ArrayList<Time> getArrayTimes() {
        return arrayTimes;
    }

    public void setArrayTimes(ArrayList<Time> arrayTimes) {
        this.arrayTimes = arrayTimes;
    }

    public Tile() {
        defesa = new Modificadores(new Color(51, 102, 255), 0.05, "Defesa");
        ataque = new Modificadores(new Color(51, 255, 51), 0.05, "Ataque");
    }

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

    //private int[][] matrizsecundaria;
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

    //pinta um quadrado especifico no modo "paint"
    public void pintaQuadrado(int x, int y) {
        int x1 = (int) x;
        int y1 = (int) y;
        g2.fillRect(x1 - (int) (escala / 2), y1 - (int) (escala / 2), this.escala, this.escala);
    }

    //gera uma cor aleatória
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

    //gera uma cor definida
    public void geraCor(int cor1) {
        switch (cor1) {
            case 0://verde escuro
                g2.setColor(new Color(0, 153, 0));
                break;
            case 1://azul escuro
                g2.setColor(new Color(51, 102, 255));
                break;
            case 2://verde claro
                g2.setColor(new Color(51, 255, 51));
                break;
            case 3://verde opaco
                g2.setColor(new Color(153, 255, 153));
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
                g2.setColor(new Color(151, 102, 0));
                break;
            case 8://areia
                g2.setColor(new Color(213, 190, 72));
                break;
            case 9://roxo
                g2.setColor(new Color(58, 0, 96));
                break;
            case 10://cinza leve
                g2.setColor(new Color(122, 113, 132));
                break;
            case 11://branco
                g2.setColor(new Color(255, 255, 255));
                break;
            default:
                System.out.println("nenhuma das cores");
                break;
        }

    }

    //confere se é possivel tomar o lugar do quadrado adjacente no modo batalha
    public boolean confereOrdem(int cor1, int cor2) {
        if (cor1 == 11) {
            return false;
        } else if (cor2 == 11) {
            return true;
        } else {
            double atacante = 0.0;
            double defensor = 0.0;
            atacante = (Math.random() * arrayTimes.get(cor1).getAtaque());
            defensor = (Math.random() * arrayTimes.get(cor2).getDefesa());
            if (atacante > defensor) {
                return true;
            } else {
                return false;
            }
        }
    }

    //Muda a imagem do quadrado derrotado e se for um de defesa ou ataque muda o atributo correspondente da cor
    public void auxBatalha(int u, int i, int u2, int i2) {
        if (matrizsecundaria[u2][i2] == 0) {
            g2.setColor(arrayTimes.get(matrizmapa[u][i]).getCor());
            g2.fillRect((u2) * tileWidth, (i2) * tileHeight, tileWidth, tileHeight);
        } else if (matrizsecundaria[u2][i2] == 1) {
            arrayTimes.get(matrizmapa[u][i]).setDefesa(arrayTimes.get(matrizmapa[u][i]).getDefesa() + defesa.getAtributo());
            arrayTimes.get(matrizmapa[u2][i2]).setDefesa(arrayTimes.get(matrizmapa[u2][i2]).getDefesa() - defesa.getAtributo());
        } else if (matrizsecundaria[u2][i2] == 2) {
            arrayTimes.get(matrizmapa[u][i]).setAtaque(arrayTimes.get(matrizmapa[u][i]).getAtaque() + ataque.getAtributo());
            arrayTimes.get(matrizmapa[u2][i2]).setAtaque(arrayTimes.get(matrizmapa[u2][i2]).getAtaque() - ataque.getAtributo());
        }
        //diminui a quantidade do derrotado
        arrayTimes.get(matrizmapa[u2][i2]).setQt(arrayTimes.get(matrizmapa[u2][i2]).getQt() - 1);
        //muda a cor perdedora para a vencedora na matriz
        matrizmapa[u2][i2] = matrizmapa[u][i];
        //aumenta a quantidade do vencedor
        arrayTimes.get(matrizmapa[u][i]).setQt(arrayTimes.get(matrizmapa[u][i]).getQt() + 1);
    }

    //confere se pode ou não ter a batalha e se sim chama o auxBatalha()
    public int auxBatalha2(int u, int i, int u2, int i2) {
        if (matrizmapa[u][i] != matrizmapa[u2][i2]) {
            boolean op = confereOrdem(matrizmapa[u][i], matrizmapa[u2][i2]);
            if (op) {
                auxBatalha(u, i, u2, i2);
            }
            return 1;
        } else {
            return 0;
        }
    }

    //inicia o modo batalha
    public void comecaBatalha(boolean d) {
        System.out.println("1");
        //quando i ou u forem 0, vai dar um erro ao se analizar u-1 e i-1, portanto o try-catch
        System.out.println("NV: " + nV);
        System.out.println("NH: " + nH);
        for (int i = 0; i < nV; i++) {
            for (int u = 0; u < nH; u++) {
                int ver = 0;
                int cont = 0;
                while (ver == 0) {
                    try {
                        int ale = (int) (Math.random() * 8);//um dos quadrados adjacentes
                        boolean op = true;
                        switch (ale) {
                            case 0:
                                // se o u e o i forem diferentes de 0 para análise de -1
                                if (u != 0 && i != 0) {
                                    ver = auxBatalha2(u, i, u - 1, i - 1);
                                } else {
                                    ver = 0;
                                }
                                break;
                            case 1:
                                if (i != 0) {
                                    ver = auxBatalha2(u, i, u, i - 1);
                                } else {
                                    ver = 0;
                                }
                                break;
                            case 2:
                                if (i != 0 && u != (nH - 1)) {
                                    ver = auxBatalha2(u, i, u + 1, i - 1);

                                } else {
                                    ver = 0;
                                }
                                break;
                            case 3:
                                if (u != 0) {
                                    ver = auxBatalha2(u, i, u - 1, i);

                                } else {
                                    ver = 0;
                                }
                                break;
                            case 4:
                                if (u != (nH - 1)) {
                                    ver = auxBatalha2(u, i, u + 1, i);
                                } else {
                                    ver = 0;
                                }
                                break;
                            case 5:
                                if (u != 0 && i != (nV - 1)) {
                                    ver = auxBatalha2(u, i, u - 1, i + 1);
                                } else {
                                    ver = 0;
                                }
                                break;
                            case 6:
                                if (i != (nV - 1)) {
                                    ver = auxBatalha2(u, i, u, i + 1);
                                } else {
                                    ver = 0;
                                }
                                break;
                            case 7:
                                if (u != (nH - 1) && i != (nV - 1)) {
                                    ver = auxBatalha2(u, i, u + 1, i + 1);
                                } else {
                                    ver = 0;
                                }
                                break;
                            default:
                                break;
                        }
                    } catch (Exception ex) {
                        String methodName = ex.getStackTrace()[0].getMethodName();
                        System.out.println("Erro! " + ex + " " + methodName);
                        ver = 0;
                    }
                    cont++;
                    if (cont == 2) {
                        ver = 1;
                    }
                }
            }
        }
    }

    //pinta o painel de branco
    public void zeraPanel(Tile panel, Color cor) {
        g2.setColor(cor);
        g2.fillRect(0, 0, panel.getWidth(), panel.getHeight());
    }

    //tenta desenhar uma neve no topo da montanha
    public void desenhaNeve(int vH, int vV) {
        geraCor(11);
        g2.fillRect(((vH - 1) * tileWidth), ((vV - 1) * tileHeight), tileWidth * 3, tileHeight * 3);
        g2.fillRect(((vH - 2) * tileWidth), (vV * tileHeight), tileWidth, tileHeight);
        g2.fillRect(((vH + 2) * tileWidth), (vV * tileHeight), tileWidth, tileHeight);
        g2.fillRect((vH * tileWidth), ((vV - 2) * tileHeight), tileWidth, tileHeight);
        g2.fillRect((vH * tileWidth), ((vV + 2) * tileHeight), tileWidth, tileHeight);
    }

    //desenha uma montanha
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

    //escolhe um ponto de começo aleatório para uma cor (usado apenas quando em fundo branco)
    public void escolheAleatorio(int cor, int nH, int nV) {
        boolean cont = true;
        while (cont) {
            int h = (int) (Math.random() * (nH - 1));
            int v = (int) (Math.random() * (nV - 1));
            //confere se já não é um ponto de começo para outra cor
            if (matrizmapa[h][v] == 11) {
                matrizmapa[h][v] = cor;
                cont = false;
            }
        }

    }

    //gera uma matriz aleatoria ou prepara uma ja definida
    public void geraMatriz(boolean a) {
        matrizmapa = new int[nH][nV];
        //se "a" é true ele gera cores aleatórias para cada posição
        if (a) {
            System.out.println("2.1");
            for (int x = 0; x < nH; x++) {
                for (int y = 0; y < nV; y++) {
                    matrizmapa[x][y] = (int) (Math.random() * 12);
                }
            }
            //se "a" é false ele pinta tudo de branco e gera lugares aleatórios
        } else {
            System.out.println("2.2");
            //pinta todas as locações de branco "11"
            for (int x = 0; x < nH; x++) {
                for (int y = 0; y < nV; y++) {
                    matrizmapa[x][y] = 11;
                }
            }
            // isso gera as cores em lugares aleatórios
            System.out.println("2.3");
            escolheAleatorio(0, nH, nV);
            escolheAleatorio(1, nH, nV);
            escolheAleatorio(2, nH, nV);
            escolheAleatorio(3, nH, nV);
            escolheAleatorio(4, nH, nV);
            escolheAleatorio(5, nH, nV);
            escolheAleatorio(6, nH, nV);
            escolheAleatorio(7, nH, nV);
            escolheAleatorio(8, nH, nV);
            escolheAleatorio(9, nH, nV);
            escolheAleatorio(10, nH, nV);
            //escolheAleatorio(11, nH, nV);
            System.out.println("2.4");

            //Isso aqui é pra gerar apenas nos cantos
//            matrizmapa[0][0] = 0;
//            matrizmapa[0][nV - 1] = 1;
//            matrizmapa[0][(int) (nV / 2)] = 7;
//            matrizmapa[nH - 1][0] = 2;
//            matrizmapa[nH - 1][nV - 1] = 3;
//            matrizmapa[nH - 1][(int) (nV / 2)] = 8;
//            matrizmapa[(int) (nH / 2)][0] = 4;
//            matrizmapa[(int) (nH / 2)][nV - 1] = 5;
//            matrizmapa[(int) (nH / 2)][(int) (nV / 2)] = 6;
        }
    }

    public void geraMatrizSecundaria(boolean a) {
        matrizsecundaria = new int[nH][nV];
        //zera  a matriz
        for (int x = 0; x < nH; x++) {
            for (int y = 0; y < nV; y++) {
                matrizsecundaria[x][y] = 0;
            }
        }
        // 1 para defesa e 2 para ataque
        // máximo de 1/15 dos quadrados totais para cada 
        System.out.println("nH: " + nH);
        System.out.println("nV: " + nV);
        double def1 = (Math.random() * ((nH * nV) / 15));
        double ata1 = (Math.random() * ((nH * nV) / 15));
        int def = (int) def1;
        int ata = (int) ata1;
        System.out.println("Def = " + def);
        System.out.println("Ata = " + ata);
        //add defesa quantas vezes for necessário
        for (int i = 0; i < def; i++) {
            boolean add = false;
            while (!add) {
                int linha = (int) (Math.random() * (nH));
                int coluna = (int) (Math.random() * (nV));
                //se ela já não conter o valor "1" e não for um ponto de partida ele é adicionado e sai do while
                if (matrizsecundaria[linha][coluna] == 0 // && matrizmapa[linha][coluna] == 12) {
                        ) {
                    matrizsecundaria[linha][coluna] = 1;
                    add = true;
                }
            }
        }
        //add ataque quantas vezes for necessário
        for (int i = 0; i < ata; i++) {
            boolean add = false;
            while (!add) {
                int linha = (int) (Math.random() * (nH));
                int coluna = (int) (Math.random() * (nV));
                //se ela já não conter o valor "2" ele é adicionado e sai do while
                if (matrizsecundaria[linha][coluna] == 0 //&& matrizmapa[linha][coluna] == 12) {
                        ) {
                    matrizsecundaria[linha][coluna] = 2;
                    add = true;
                }
            }
        }
    }

    public void geraTimes() {
        //gera 12 times
        for (int i = 0; i < 12; i++) {
            Time time = new Time();
            time.setNome("Time " + String.valueOf(i));
            time.setQt(1);
            time.setCor(listaCores(i));
            time.setAtaque(5.0);
            time.setDefesa(5.0);
            arrayTimes.add(time);
        }
    }

    // cores dos times
    public Color listaCores(int cont) {
        Color novaCor = null;
        switch (cont) {
            case 0:
                novaCor = new Color(63, 0, 0);
                break;
            case 1:
                novaCor = new Color(63, 63, 0);
                break;
            case 2:
                novaCor = new Color(63, 63, 63);
                break;
            case 3:
                novaCor = new Color(126, 63, 63);
                break;
            case 4:
                novaCor = new Color(126, 126, 63);
                break;
            case 5:
                novaCor = new Color(126, 126, 126);
                break;
            case 6:
                novaCor = new Color(189, 126, 126);
                break;
            case 7:
                novaCor = new Color(189, 189, 126);
                break;
            case 8:
                novaCor = new Color(189, 189, 189);
                break;
            case 9:
                novaCor = new Color(252, 189, 189);
                break;
            case 10:
                novaCor = new Color(252, 252, 189);
                break;
            case 11:
                novaCor = new Color(252, 252, 252);
                break;
            default:
                break;
        }
        return novaCor;
    }

//define quantos quadrados terá a tela de acordo com os tamanhos definidos
    public void desenhaGrid(Tile panel, boolean a) {
        zeraPanel(panel, Color.WHITE);
        arrayTimes.clear();
        nH = panel.getWidth() / tileWidth;
        nV = panel.getHeight() / tileHeight;
        System.out.println("1");
        geraTimes();
        System.out.println("2");
        geraMatriz(a);
        System.out.println("3");
        geraMatrizSecundaria(a);
        System.out.println("4");
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
        if (k == 1) {
            //pinta os valores da matrizsecundaria
            for (int i1 = 0; i1 < nH; i1++) {
                for (int i2 = 0; i2 < nV; i2++) {
                    if (matrizsecundaria[i1][i2] == 1) {
                        g2.setColor(defesa.getCor());
                        g2.fillRect(i1 * tileWidth, i2 * tileHeight, tileWidth, tileHeight);
                    } else if (matrizsecundaria[i1][i2] == 2) {
                        g2.setColor(ataque.getCor());
                        g2.fillRect(i1 * tileWidth, i2 * tileHeight, tileWidth, tileHeight);
                    }
                }
            }
        }
        //pinta os valores do matriz mapa
        for (int i1 = 0; i1 < nH; i1++) {
            for (int i2 = 0; i2 < nV; i2++) {
                if (matrizsecundaria[i1][i2] == 0) {
                    //pinta com a cor de acordo com o número do time
                    if (matrizmapa[i1][i2] == 11) {
                        g2.setColor(Color.WHITE);
                    } else {
                        g2.setColor(arrayTimes.get(matrizmapa[i1][i2]).getCor());
                    }
                    g2.fillRect(i1 * tileWidth, i2 * tileHeight, tileWidth, tileHeight);
                }
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
