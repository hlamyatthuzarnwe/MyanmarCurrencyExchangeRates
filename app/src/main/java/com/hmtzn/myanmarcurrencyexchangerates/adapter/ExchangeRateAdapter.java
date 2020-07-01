package com.hmtzn.myanmarcurrencyexchangerates.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hmtzn.myanmarcurrencyexchangerates.R;
import com.hmtzn.myanmarcurrencyexchangerates.model.Rates;
import com.hmtzn.myanmarcurrencyexchangerates.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ExchangeRateAdapter extends RecyclerView.Adapter<ExchangeRateAdapter.ExchangeRateViewHolder> {

    private static final String TAG = "ExchangeRateAdapter";
    private List<Rates> ratesList = new ArrayList();
    private List<Response> responseList = new ArrayList<>();

    public void clear() {
        ratesList.clear();
        responseList.clear();
    }

    @NonNull
    @Override
    public ExchangeRateAdapter.ExchangeRateViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_exchange_rates, viewGroup, false);
        return new ExchangeRateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExchangeRateAdapter.ExchangeRateViewHolder holder, int position) {

        holder.bindResopnse(responseList.get(position));
        holder.bindRates(ratesList.get(position));

    }

    @Override
    public int getItemCount() {
        return ratesList.size();
    }

    public List getRatesList() {
        return ratesList;
    }


    public class ExchangeRateViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private Context context;

        @BindView(R.id.tv_info)
        TextView tvInfo;

        @BindView(R.id.tv_description)
        TextView tvDescription;

        @BindView(R.id.tv_timestamp)
        TextView tvTimestamp;

        @BindView(R.id.tv_cHF)
        TextView tvChf;

        @BindView(R.id.tv_sAR)
        TextView tvSar;

        @BindView(R.id.tv_zAR)
        TextView tvZar;

        @BindView(R.id.tv_iNR)
        TextView tvInr;

        @BindView(R.id.tv_vND)
        TextView tvVnd;

        @BindView(R.id.tv_cNY)
        TextView tvCny;

        @BindView(R.id.tv_tHB)
        TextView tvThb;

        @BindView(R.id.tv_aUD)
        TextView tvAud;

        @BindView(R.id.tv_iLS)
        TextView tvIls;

        @BindView(R.id.tv_nPR)
        TextView tvNpr;

        @BindView(R.id.tv_kRW)
        TextView tvKrw;

        @BindView(R.id.tv_jPY)
        TextView tvJpy;

        @BindView(R.id.tv_bDT)
        TextView tvBdt;

        @BindView(R.id.tv_kHR)
        TextView tvKhr;

        @BindView(R.id.tv_gBP)
        TextView tvGbp;

        @BindView(R.id.tv_iDR)
        TextView tvIdp;

        @BindView(R.id.tv_kWD)
        TextView tvKwd;

        @BindView(R.id.tv_pHP)
        TextView tvPhp;

        @BindView(R.id.tv_rUB)
        TextView tvRub;

        @BindView(R.id.tv_hKD)
        TextView tvHkd;

        @BindView(R.id.tv_rSD)
        TextView tvRsd;

        @BindView(R.id.tv_eUR)
        TextView tvEur;

        @BindView(R.id.tv_dKK)
        TextView tvDkk;

        @BindView(R.id.tv_uSD)
        TextView tvUsd;

        @BindView(R.id.tv_mYR)
        TextView tvMyr;

        @BindView(R.id.tv_cAD)
        TextView tvCad;

        @BindView(R.id.tv_nOK)
        TextView tvNok;

        @BindView(R.id.tv_eGP)
        TextView tvEgp;

        @BindView(R.id.tv_sGD)
        TextView tvSgd;

        @BindView(R.id.tv_lKR)
        TextView tvLkr;

        @BindView(R.id.tv_cZK)
        TextView tvCzk;

        @BindView(R.id.tv_pKR)
        TextView tvPkr;

        @BindView(R.id.tv_lAK)
        TextView tvLak;

        @BindView(R.id.tv_sEK)
        TextView tvSek;

        @BindView(R.id.tv_kES)
        TextView tvKes;

        @BindView(R.id.tv_bND)
        TextView tvBnd;

        @BindView(R.id.tv_nZD)
        TextView tvNzd;

        @BindView(R.id.tv_bRL)
        TextView tvBrl;

        public ExchangeRateViewHolder(@NonNull View itemView) {

            super(itemView);

            context = itemView.getContext();
            view = itemView;

        }

        public void bindResopnse(final Response response) {
            if (response != null) {

                if (response.getInfo() != null) {
                    tvInfo.setText(response.getInfo());
                }
                if (response.getDescription() != null) {
                    tvDescription.setText(response.getDescription());
                }
                if (response.getTimestamp() != null) {
                    tvTimestamp.setText(response.getTimestamp());
                }
            }
        }

        public void bindRates(final Rates rates) {

            if (rates != null) {

                if (rates.getCHF() != null) {
                    tvChf.setText(rates.getCHF());
                }
                if (rates.getSAR() != null) {
                    tvSar.setText(rates.getSAR());
                }
                if (rates.getZAR() != null) {
                    tvZar.setText(rates.getZAR());
                }
                if (rates.getINR() != null) {
                    tvInr.setText(rates.getINR());
                }
                if (rates.getVND() != null) {
                    tvVnd.setText(rates.getVND());
                }
                if (rates.getCNY() != null) {
                    tvCny.setText(rates.getCNY());
                }
                if (rates.getTHB() != null) {
                    tvThb.setText(rates.getTHB());
                }
                if (rates.getAUD() != null) {
                    tvAud.setText(rates.getAUD());
                }
                if (rates.getILS() != null) {
                    tvIls.setText(rates.getILS());
                }
                if (rates.getNPR() != null) {
                    tvNpr.setText(rates.getNPR());
                }
                if (rates.getKRW() != null) {
                    tvKrw.setText(rates.getKRW());
                }
                if (rates.getJPY() != null) {
                    tvJpy.setText(rates.getJPY());
                }
                if (rates.getBDT() != null) {
                    tvBdt.setText(rates.getBDT());
                }
                if (rates.getKHR() != null) {
                    tvKhr.setText(rates.getKHR());
                }
                if (rates.getGBP() != null) {
                    tvGbp.setText(rates.getGBP());
                }
                if (rates.getIDR() != null) {
                    tvIdp.setText(rates.getIDR());
                }
                if (rates.getKWD() != null) {
                    tvKwd.setText(rates.getKWD());
                }
                if (rates.getPHP() != null) {
                    tvPhp.setText(rates.getPHP());
                }
                if (rates.getRUB() != null) {
                    tvRub.setText(rates.getRUB());
                }
                if (rates.getHKD() != null) {
                    tvHkd.setText(rates.getHKD());
                }
                if (rates.getRSD() != null) {
                    tvRsd.setText(rates.getRSD());
                }
                if (rates.getEUR() != null) {
                    tvEur.setText(rates.getEUR());
                }
                if (rates.getDKK() != null) {
                    tvDkk.setText(rates.getDKK());
                }
                if (rates.getUSD() != null) {
                    tvUsd.setText(rates.getUSD());
                }
                if (rates.getMYR() != null) {
                    tvMyr.setText(rates.getMYR());
                }
                if (rates.getCAD() != null) {
                    tvCad.setText(rates.getCAD());
                }
                if (rates.getNOK() != null) {
                    tvNok.setText(rates.getNOK());
                }
                if (rates.getEGP() != null) {
                    tvEgp.setText(rates.getEGP());
                }
                if (rates.getSGD() != null) {
                    tvSgd.setText(rates.getSGD());
                }
                if (rates.getLKR() != null) {
                    tvLkr.setText(rates.getLKR());
                }
                if (rates.getCZK() != null) {
                    tvCzk.setText(rates.getCZK());
                }
                if (rates.getPKR() != null) {
                    tvPkr.setText(rates.getPKR());
                }
                if (rates.getLAK() != null) {
                    tvLak.setText(rates.getLAK());
                }
                if (rates.getSEK() != null) {
                    tvSek.setText(rates.getSEK());
                }
                if (rates.getKES() != null) {
                    tvSek.setText(rates.getSEK());
                }
                if (rates.getBND() != null) {
                    tvBnd.setText(rates.getBND());
                }
                if (rates.getNZD() != null) {
                    tvNzd.setText(rates.getNZD());
                }
                if (rates.getBRL() != null) {
                    tvBrl.setText(rates.getBRL());
                }
            }
        }


    }

}
