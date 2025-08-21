package br.com.fiap.bean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe representa o objeto personagem Dragon Ball Super
 * Implementa interface com as caractericas do personagem
 * @version 1
 * @author Mariana Inoue
 */
public class DragonBallSuper {
    private int ki;
    private int tecnica;
    private int velocidade;
    private int transformacao;
    private String nome;

    public DragonBallSuper() {
    }

    public int getKi() {
        return ki;
    }

    public void setKi(int ki) {
        this.ki = ki;
    }

    public int getTecnica() {
        return tecnica;
    }

    public void setTecnica(int tecnica) {
        this.tecnica = tecnica;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getTransformacao() {
        return transformacao;
    }

    public void setTransformacao(int transformacao) {
        this.transformacao = transformacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que lê os arquivo com informações do personagem de Dragon Ball Super
     * @param path
     * @return
     * @throws IOException
     */
    public DragonBallSuper ler(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path + "/" + nome + ".txt"));
        nome = br.readLine();
        ki = Integer.parseInt(br.readLine());
        transformacao = Integer.parseInt(br.readLine());
        velocidade = Integer.parseInt(br.readLine());
        tecnica = Integer.parseInt(br.readLine());
        br.close();
        return this;
    }

    /**
     * Método que grava um arquivo com as caracteristicas informadas pelo usuario
     * @param path
     * @return
     */

    public String gravar(String path) {
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdir();
            }
            PrintWriter pw = new PrintWriter(path + "/" + nome + ".txt");
            pw.println(nome);
            pw.println(ki);
            pw.println(transformacao);
            pw.println(velocidade);
            pw.println(tecnica);
            pw.flush();
            pw.close();
            return "Arquivo gravado com sucesso";
        } catch (IOException e) {
            return "Falha ao gravar arquivo: " + e.getMessage();
        }
    }
}
