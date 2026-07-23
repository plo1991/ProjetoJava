package com.projetotestejava.service;

import org.springframework.stereotype.Service;
import com.projetotestejava.dto.HolidayResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class HolidayService {
    public List<HolidayResponse> getFeriadosNacionais(int ano) {
        List<HolidayResponse> feriados = new ArrayList<>();
        feriados.add(new HolidayResponse(ano + "-01-01", "Ano Novo", "Nacional"));
        feriados.add(new HolidayResponse(ano + "-04-21", "Tiradentes", "Nacional"));
        feriados.add(new HolidayResponse(ano + "-05-01", "Dia do Trabalho", "Nacional"));
        feriados.add(new HolidayResponse(ano + "-09-07", "Independência", "Nacional"));
        feriados.add(new HolidayResponse(ano + "-10-12", "Nossa Senhora Aparecida", "Nacional"));
        feriados.add(new HolidayResponse(ano + "-11-02", "Finados", "Nacional"));
        feriados.add(new HolidayResponse(ano + "-11-20", "Consciência Negra", "Nacional"));
        feriados.add(new HolidayResponse(ano + "-12-25", "Natal", "Nacional"));
        return feriados;
    }
}
