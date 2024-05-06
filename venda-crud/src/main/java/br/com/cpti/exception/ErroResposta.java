package br.com.cpti.exception;

import java.time.LocalDate;
import java.util.List;

public class ErroResposta {

    private Integer status;
    private String Titulo;
    private LocalDate dataHora;

    //GET AND SET
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public LocalDate getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    //OVERRIDE
    @Override
    public String toString() {
        return "ErroResposta [status=" + status + ", Titulo=" + Titulo + ", dataHora=" + dataHora + "]";
    }

    //CONSTRUCT USING FIELDS
    public ErroResposta(Integer status, String titulo, LocalDate dataHora, List<String> erros) {
        super();
        this.status = status;
        Titulo = titulo;
        this.dataHora = dataHora;
    }



}