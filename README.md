# ProMDM
zadatak
Activity MainActivity.class je glavni i jedini activity u aplikaciji. 
initAlarm() sadrži AlarmManager koji kad je aktivan, se pokreće svako pet sekundi, Intent koji pokazuje prema AlarmReceiver i PadingIntent koji pokreće zadani Broadcast.
setupListener() postavlja onClick na Button-e. btnStart pokreće, a btnStop zaustavlja AlarmManager.
AlarmReceiver.class samo starta IntentService SendDataService.
Za povezivanje sa serverom se koristi biblioteka okhttp3.
U SendDataService.class  u metodi onHandleIntent je inicijaliziran OkhttpClient i RequestBody koji sadrži metodu  TrafficStats.getMobileRxBytes()koja dohvaća potrošen internet promet i on se šalje na server. Pomoću Handler-a se ispisuju Toast poruke da se vidi kad  je aktiviran servis.
