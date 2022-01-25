@Override public int compare(final Report record1, final Report record2) {
    int c;
    c = record1.getReportKey().compareTo(record2.getReportKey());
    if (c == 0)
       c = record1.getStudentNumber().compareTo(record2.getStudentNumber());
    if (c == 0)
       c = record1.getSchool().compareTo(record2.getSchool());
    return c;
}

Also

List<String> someList = new ArrayList<>(map.keySet());
Collections.sort(someList, new Comparator<int[]>(){
@Override
    public int compare(int[] n1, int[] n2)
    {
        int c = 0;
        c = n1[0] - n2[0];
        if(c == 0)
            c = n1[1] - n2[1];
        return c;
    }
});
