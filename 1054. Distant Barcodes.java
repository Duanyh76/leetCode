class Solution {
    private Queue<CodeStatus> queue = new PriorityQueue<>(new Comparator<CodeStatus>() {
        @Override
        public int compare(CodeStatus o1, CodeStatus o2) {
            return o2.getCount() - o1.getCount();
        }
    });

    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] codeMap = new int[10001];
        for (int code : barcodes) {
            codeMap[code]++;
        }
        for (int code = 1; code <= 10000; code++) {
            CodeStatus codeStatus = new CodeStatus(code, codeMap[code]);
            queue.add(codeStatus);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            CodeStatus codeStatus = queue.poll();
            int count = codeStatus.getCount();
            int val = codeStatus.getVal();
            for (int countIndex = 0; countIndex < count; countIndex++) {
                if (index >= barcodes.length) {
                    index = 1;
                }
                barcodes[index] = val;
                index += 2;
            }
        }
        return barcodes;
    }

    class CodeStatus {
        int val;
        int count;

        public CodeStatus(int val, int count) {
            this.val = val;
            this.count = count;
        }

        public int getVal() {
            return val;
        }

        public int getCount() {
            return count;
        }
    }
}